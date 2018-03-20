package MainCore;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;

public class CameraGUI {

	private JFrame frmCameraAlarm;
	private String cameraNo;
	private String homehName;
	private int zone;
	private Camera camera;
	private JLabel lblAlarmStatus;

	

	public CameraGUI(String[] strings) {
		this.cameraNo = strings[0];
		this.homehName = strings[1];
		this.zone = Integer.valueOf(strings[2]);
		System.out.println(this.zone);
		initialize();
		camera = new Camera(this, this.cameraNo, this.homehName, this.zone);
		System.out.println(cameraNo + homehName + zone);
	}

	
	private void initialize() {
		frmCameraAlarm = new JFrame();
		frmCameraAlarm.setBackground(Color.ORANGE);
		frmCameraAlarm.getContentPane().setBackground(Color.ORANGE);
		frmCameraAlarm.setBounds(100, 100, 235, 119);
		frmCameraAlarm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCameraAlarm.getContentPane().setLayout(null);
		
		JToggleButton btnNewButton = new JToggleButton("Activate Alarm");
		btnNewButton.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			        camera.triggerAlarm();
			        setActivationText();
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			        camera.triggerAlarm();
			        setActivationText();
			      }
			   }
		});

		btnNewButton.setBounds(10, 11, 199, 32);
		frmCameraAlarm.getContentPane().add(btnNewButton);
		
		lblAlarmStatus = new JLabel("Camera Status: Deactivated");
		lblAlarmStatus.setBounds(10, 54, 199, 14);
		frmCameraAlarm.getContentPane().add(lblAlarmStatus);
		frmCameraAlarm.setTitle("Camera Alarm");
		frmCameraAlarm.setVisible(true);
	}
	
	private void setActivationText(){
		boolean status = camera.currentStatus();
		System.out.println(status);
		if (status == true){
			lblAlarmStatus.setText("Camera Status:" + " " + "Activated");
		} else {
			lblAlarmStatus.setText("Camera Alarm Status:" + " " + "Deactivated");
		}
	}
}

