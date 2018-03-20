package MainCore;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import RegionalOffice.*;

public class Regoff extends REGOFFPOA{

	private RegoffGUI regoffGUI;

	public Regoff(RegoffGUI regoffGUI) {
		this.regoffGUI = regoffGUI;
		init();
	}

	
	public void registerUser(userName user, contactDetails contact) {
		
		
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
			BufferedWriter out = new BufferedWriter(new FileWriter("REGOFF.ref"));
			out.write(stringified_ior);
			
			out.close();

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}

	
	// This informs the police
	public void raiseAlarm(Alarm aSensor, Alarm aCamera) {
		regoffGUI.addAlarmInfo(aSensor.homeh + " Recieved alarm from " + aSensor.zone + " triggered by\n"
				+ aSensor.name + " and " + aCamera.name + " informing the Police");
	
		
	}

	@Override
	public void connectHOMEH(String homehName) {
		regoffGUI.addHOMEH(homehName);
		regoffGUI.addMessageToConsole(homehName + " Connected");
		
	}

}
