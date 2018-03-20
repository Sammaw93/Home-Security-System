package MainCore;

import java.io.BufferedReader;
import java.io.FileReader;

import org.omg.CORBA.ORB;

import HomeHub.Alarm;
import HomeHub.HOMEH;

public class Sensor {

	private String sensorName;
	private String homehName;
	private int zone;
	private Alarm sensor;
	private SensorGUI sensorGUI;
	private boolean sensorStatus;

	public Sensor(SensorGUI sensorGUI, String sensorName, String homehName, int zone){
		this.sensorGUI = sensorGUI;
		this.sensorName = sensorName;
		this.homehName = homehName;
		this.zone = zone;
		this.sensorStatus = false;
		this.sensor = new Alarm(this.sensorName, this.homehName, this.zone, this.sensorStatus);
		connect();
	}

	public void connect(){
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader(this.homehName +".ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = 		
					orb.string_to_object(stringified_ior);

			final HomeHub.HOMEH homeh = 
					HomeHub.HOMEHHelper.narrow(server_ref);

			homeh.add_Sensor(this.sensor);

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}
	
	public void alarmRaised(){
		this.sensor = new Alarm(this.sensorName, this.homehName, this.zone, this.sensorStatus);
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(new String[]{}, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader(this.homehName +".ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = 		
					orb.string_to_object(stringified_ior);

			final HomeHub.HOMEH homeh = 
					HomeHub.HOMEHHelper.narrow(server_ref);
			homeh.raise_Alarm(this.sensor);
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}

	public void triggerAlarm(){
		sensorStatus = !sensorStatus;
	}
	
	public boolean current(){
		return sensorStatus;
	}
}
