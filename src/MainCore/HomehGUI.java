package MainCore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;

public class HomehGUI {

	private JFrame frmHomeHub;
	private String homehName;
	private Homeh homehServer;
	private JTextArea textArea;

	
	public HomehGUI(String[] strings) {
		this.homehName = strings[0];
		initialize();
		this.homehServer = new Homeh(this, this.homehName);
	}

	
	private void initialize() {
		frmHomeHub = new JFrame();
		frmHomeHub.setBackground(Color.ORANGE);
		frmHomeHub.getContentPane().setBackground(Color.ORANGE);
		frmHomeHub.setBounds(100, 100, 317, 438);
		frmHomeHub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomeHub.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 281, 378);
		frmHomeHub.getContentPane().add(textArea);
		frmHomeHub.setTitle("Home Hub");
		frmHomeHub.setVisible(true);
	}
	
	public void appendText(String message){
		System.out.println(message);
		textArea.append(message + "\n");
	}
}
