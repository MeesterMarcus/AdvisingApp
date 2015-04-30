package advising;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
* Creates the view for the Welcome Screen at the beginning
* of the program
* @author David A. Balboa
*/

public class WelcomeView extends JFrame implements ActionListener{
	//private JPanel centerPanel;
	
	JPanel menu;
	JButton btnSignIn;
	JButton btnSetUpAppt;
	
	public WelcomeView(){
		//Window Title
		super("Welcome!");
		
		menu = new JPanel();
		menu.setLayout(null);		
		
		//Sign In button
		btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnSignIn.setBounds(415, 185, 230, 116);
		btnSignIn.setActionCommand("signin");
		menu.add(btnSignIn, BorderLayout.CENTER);
		
		//Set Up Appointment button
		btnSetUpAppt = new JButton("<html><center>Set Up an </br>Appointment</center></html>");
		btnSetUpAppt.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnSetUpAppt.setBounds(95, 185, 230, 116);
		btnSetUpAppt.setActionCommand("appt");
		menu.add(btnSetUpAppt, BorderLayout.CENTER);
		
		//Welcome message + user prompt
		JLabel choosePrompt1 = new JLabel("WELCOME!");
		JLabel choosePrompt2 = new JLabel("What would you like to do?");
		choosePrompt1.setFont(new Font("SansSerif", Font.BOLD, 50));
		choosePrompt2.setFont(new Font("SansSerif", Font.BOLD, 30));
		choosePrompt1.setBounds(230, 20, 540, 113);
		choosePrompt2.setBounds(175, 70, 540, 113);
		menu.add(choosePrompt1);
		menu.add(choosePrompt2);
		
		//Add Panel to JFrame
		add(menu);
	}
	
	public void actionPerformed(ActionEvent e){
		String text = e.getActionCommand();
		if(text.equals("appt")){
			System.out.println("Appt option selected!");
			System.exit(0);
		}
		if(text.equals("signin")){
			System.out.println("Sign in option selected!");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		WelcomeView window = new WelcomeView();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(760, 425);
		window.setVisible(true);
		window.getMouseListeners();
	}
}
