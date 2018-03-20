package MainCore;

import java.awt.EventQueue;

public class setup {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RegoffGUI();
					new HomehGUI(new String[]{"homeh1"});
					new SensorGUI(new String[]{"sensor1", "homeh1", "1"});
					new CameraGUI(new String[]{"camera1", "homeh1", "1"});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
