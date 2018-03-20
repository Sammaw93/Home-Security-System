package MainCore;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Color;

public class SensorGUI {

	private JFrame frmSensorAlarm;
	private String sensorName;
	private String homehName;
	private int zone;
	private Sensor sensor;
	private JLabel lblSensorAlarmStatus;

	
	public SensorGUI(String[] strings) {
		this.sensorName = strings[0];
		this.homehName = strings[1];
		this.zone = Integer.valueOf(strings[2]);
		this.sensor = new Sensor(this, this.sensorName, this.homehName, this.zone);
		initialize();
	}

	private void initialize() {
		frmSensorAlarm = new JFrame();
		frmSensorAlarm.setBackground(Color.ORANGE);
		frmSensorAlarm.getContentPane().setBackground(Color.ORANGE);
		frmSensorAlarm.setBounds(100, 100, 240, 116);
		frmSensorAlarm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSensorAlarm.getContentPane().setLayout(null);
		
		JToggleButton btnNewButton = new JToggleButton("Trigger Sensor");
		btnNewButton.addItemListener(new ItemListener() {
			   public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			        sensor.triggerAlarm();
			        setActivationText();
			        sensor.alarmRaised();
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			        sensor.triggerAlarm();;
			        setActivationText();
			      }
			   }
		});
		btnNewButton.setBounds(10, 11, 204, 32);
		frmSensorAlarm.getContentPane().add(btnNewButton);
		
		lblSensorAlarmStatus = new JLabel("Sensor Status: Deactivated");
		lblSensorAlarmStatus.setBounds(10, 55, 224, 14);
		frmSensorAlarm.getContentPane().add(lblSensorAlarmStatus);
		frmSensorAlarm.setTitle("Sensor Alarm");
		frmSensorAlarm.setVisible(true);
	}
	
	private void setActivationText(){
		boolean status = sensor.current();
		System.out.println(status);
		if (status == true){
			lblSensorAlarmStatus.setText("Sensor Status:" + " " + "Activated");
		} else {
			lblSensorAlarmStatus.setText("Sensor Status:" + " " + "Deactivated");
		}
	}

}
