package MainCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.sound.midi.Sequence;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import HomeHub.*;

public class Homeh extends HOMEHPOA {

	private String homehName;
	private HomehGUI homehGUI;
	private Alarm sensorAlarm;
	private CORBAServer.Alarm cameraAlarm;
	private Alarm cameraHOMEHAlarm;
	private Hashtable<Integer, Hashtable<String, Alarm>> zone;
	private Alarm[] log;

	public Homeh(HomehGUI homehGUI, String homehName) {
		this.homehGUI = homehGUI;
		this.homehName = homehName;
		init();
		connectToREGOFF();
		log = new Alarm[50];
		zone = new Hashtable<Integer , Hashtable<String, Alarm>>();
		
	}

	
	public String name() {
	
		return null;
	}

	
	public Alarm[] theLog() {
		
		return log;
	}

	@Override
	public void raise_Alarm(Alarm alarm) {
		this.sensorAlarm = alarm;
		homehGUI.appendText("Sensor: " + this.sensorAlarm.name + " in zone: " + sensorAlarm.zone + " was triggered\n"
				+ "Checking camera status");
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader("camera1" + this.homehName + this.sensorAlarm.zone + ".ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = 		
					orb.string_to_object(stringified_ior);

			final CORBAServer.CamCorba camera = 
					CORBAServer.CamCorbaHelper.narrow(server_ref);
			boolean status;
			this.cameraAlarm = camera.getAlarm();
			cameraHOMEHAlarm = changeAlarmType(cameraAlarm);
			System.out.println(this.cameraHOMEHAlarm.name + " " + this.cameraHOMEHAlarm.zone);
			if(this.cameraHOMEHAlarm.status == true){
				homehGUI.appendText("Camera: " + this.cameraHOMEHAlarm.name + " in zone: " + this.cameraHOMEHAlarm.zone + " also triggered\n"
						+ "Informing REGOFF");
				addToLog(sensorAlarm);
				addToLog(cameraHOMEHAlarm);
				informREGOFF(sensorAlarm, cameraAlarm);
				
			} else {
				System.out.println(this.cameraAlarm.name + " " + this.cameraAlarm.zone);
				homehGUI.appendText("Camera: " + this.cameraHOMEHAlarm.name + " in zone: " + this.cameraHOMEHAlarm.zone + " wasnt triggered\n"
						+ "False report, Aborting");
			}

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}

	}

	
	public void add_Camera(Alarm aCamera) {
		Hashtable <String, Alarm> camera = new Hashtable<String, Alarm>();
		camera.put(aCamera.name, aCamera);
		this.zone.put(aCamera.zone, camera);
		homehGUI.appendText("Camera: " + aCamera.name + " from zone: " + aCamera.zone + " Connected");
		
	}

	public void add_Sensor(Alarm aSensor){
		Hashtable <String, Alarm> sensor = new Hashtable<String, Alarm>();
		sensor.put(aSensor.name, aSensor);
		this.zone.put(aSensor.zone, sensor);
		homehGUI.appendText("Sensor: " + aSensor.name + " from zone: " + aSensor.zone + " Connected");

	}

	public void connectToREGOFF(){
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader("REGOFF.ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = 		
					orb.string_to_object(stringified_ior);

			final RegionalOffice.REGOFF rEGOFF = 
					RegionalOffice.REGOFFHelper.narrow(server_ref);
			
			rEGOFF.connectHOMEH(this.homehName);
			homehGUI.appendText("Connected To REGOFF");

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}

	}

	public void init(){
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB


			// get the 'stringified IOR'
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(this);
			String stringified_ior = orb.object_to_string(ref);

			// Save IOR to file
			BufferedWriter out = new BufferedWriter(new FileWriter(this.homehName + ".ref"));
			out.write(stringified_ior);

			homehGUI.appendText("Server Started");

			out.close();

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
	
	public void informREGOFF(Alarm aSensor, CORBAServer.Alarm cameraAlarm){
		RegionalOffice.Alarm rEGOFFSensor = new RegionalOffice.Alarm(aSensor.name, aSensor.homeh, aSensor.zone, aSensor.status);
		RegionalOffice.Alarm rEGOFFCamera = new RegionalOffice.Alarm(cameraAlarm.name, cameraAlarm.homeh, cameraAlarm.zone, cameraAlarm.status);
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader("REGOFF.ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = 		
					orb.string_to_object(stringified_ior);

			final RegionalOffice.REGOFF rEGOFF = 
					RegionalOffice.REGOFFHelper.narrow(server_ref);
			
			rEGOFF.raiseAlarm(rEGOFFSensor, rEGOFFCamera);
			homehGUI.appendText("Information relayed to REGOFF");

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}

	}
	
	private void addToLog(Alarm alarm){
		for(int i=0; i<log.length; i++){
			if(log[i] == null){
				log[i] = alarm;
				break;
			}
		}
		for(Alarm a: log){
			System.out.println(a);
		}
	}
	
	private Alarm changeAlarmType(CORBAServer.Alarm alarm){
		Alarm homehAlarm = new Alarm(alarm.name, alarm.homeh, alarm.zone, alarm.status);
		return homehAlarm;
	}

	@Override
	public double getNoZones() {
		
		return 0;
	}
	
	
	
	
	

}
