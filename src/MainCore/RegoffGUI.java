package MainCore;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;

public class RegoffGUI {
	
	private Regoff regoff;

	private JFrame frmRegionalOffice;

	private JComboBox comboBox;

	private JTextArea textArea_1;

	private JTextArea textArea;

	private List list;

	
	public RegoffGUI() {
		initialize();
		this.regoff = new Regoff(this);
	}

	
	private void initialize() {
		frmRegionalOffice = new JFrame();
		frmRegionalOffice.setBackground(Color.ORANGE);
		frmRegionalOffice.getContentPane().setBackground(Color.ORANGE);
		frmRegionalOffice.setBounds(100, 100, 564, 490);
		frmRegionalOffice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegionalOffice.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 39, 291, 175);
		frmRegionalOffice.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Alarm Activity:");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(10, 11, 291, 14);
		frmRegionalOffice.getContentPane().add(lblNewLabel);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(311, 298, 227, 143);
		frmRegionalOffice.getContentPane().add(textArea_1);
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(311, 273, 227, 14);
		frmRegionalOffice.getContentPane().add(lblConsole);
		
		comboBox = new JComboBox();
		comboBox.setBounds(342, 64, 167, 20);
		frmRegionalOffice.getContentPane().add(comboBox);
		comboBox.addItem("Choose HOMEH...");
		comboBox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (comboBox.getSelectedIndex() !=0){
						String homeh = getSelectedHOMEH();
						
					}
				}
			
		});
		
		
		JLabel lblSelectedHomeh = new JLabel("HomeHub's Connected:");
		lblSelectedHomeh.setBounds(332, 39, 169, 14);
		frmRegionalOffice.getContentPane().add(lblSelectedHomeh);
		
		list = new List();
		list.setBounds(338, 179, 110, 69);
		frmRegionalOffice.getContentPane().add(list);
		
		JLabel lblZonesInHomeh = new JLabel("HomeHub Zones:");
		lblZonesInHomeh.setBounds(332, 146, 169, 14);
		frmRegionalOffice.getContentPane().add(lblZonesInHomeh);
		
		List list_1 = new List();
		list_1.setBounds(153, 339, 110, 92);
		frmRegionalOffice.getContentPane().add(list_1);
		
		List list_2 = new List();
		list_2.setBounds(153, 229, 110, 92);
		frmRegionalOffice.getContentPane().add(list_2);
		
		JLabel lblSensors = new JLabel("Sensors:");
		lblSensors.setBounds(37, 259, 110, 14);
		frmRegionalOffice.getContentPane().add(lblSensors);
		
		JLabel lblCameras = new JLabel("Cameras:");
		lblCameras.setBounds(37, 372, 110, 14);
		frmRegionalOffice.getContentPane().add(lblCameras);
		
		frmRegionalOffice.setTitle("Regional Office");
		frmRegionalOffice.setVisible(true);
	}
	
	public void addHOMEH(String homehName){
		comboBox.addItem(homehName);
		System.out.println(comboBox.getItemAt(1));
	}
	
	public void addMessageToConsole(String message){
		textArea_1.append(message + "\n");
	}
	
	public void addAlarmInfo(String message){
		textArea.append(message + "\n");
	}
	
	public String getSelectedHOMEH(){
		String homehName = comboBox.getSelectedItem().toString();
		return homehName;
	}
	
	public void wipeZones(){
		list.removeAll();
	}
	
	public void addZone(int i){
		list.add("Zone " + i);
	}
}
