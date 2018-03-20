package MainCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CORBAServer.*;

class Camera extends CamCorbaPOA {
	private ORB orb;
	private HomeHub.HOMEH HOMEHServer;
	private CameraGUI parent;

	private Image camera1 = new Image(0100, 2, "Im a camera");
	public Alarm camera;
	private HomeHub.Alarm cameraSwapped;
	private String cameraNo;
	private String homehName;
	private int zone;
	private boolean cameraStatus;

	

	public Camera(CameraGUI cameraGUI, String cameraNo, String homehName, int zone){
		parent = cameraGUI;
		this.cameraNo = cameraNo;
		this.homehName = homehName;
		this.zone = zone;
		this.cameraStatus = false;
		init();
		camera = new Alarm(this.cameraNo,this.homehName, this.zone, this.cameraStatus);
		connect();
	}

		
	
	public String name() {
		return cameraNo;
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
			cameraSwapped = alarmSwapper(this.camera);
			homeh.add_Camera(this.cameraSwapped);

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
			BufferedWriter out = new BufferedWriter(new FileWriter(cameraNo + homehName + zone + ".ref"));
			out.write(stringified_ior);
			out.close();

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}

	}

	
	public boolean currentStatus() {
		return cameraStatus;	
	}
	
	public Alarm getAlarm(){
		camera.status = currentStatus();
		return camera;
	}


	@Override
	public Image CurrentImage() {
		
		return null;
	}
	
	public void triggerAlarm(){
		cameraStatus = !cameraStatus;
		
	}
	
	public HomeHub.Alarm alarmSwapper(Alarm camera){
		Alarm cameratemp = camera;
		HomeHub.Alarm convertedAlarm = new HomeHub.Alarm(cameratemp.name, cameratemp.homeh, cameratemp.zone, cameratemp.status);
		return convertedAlarm;
	}

}
