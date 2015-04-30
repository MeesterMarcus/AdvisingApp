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

public class ThankYouView extends JFrame implements ActionListener{
	//private JPanel centerPanel;
	
	JPanel menu;
	JButton btnExit;
	JButton btnSetUpAppt;
	
	public ThankYouView(){
		//Window Title
		super("Thank You!");
		
		menu = new JPanel();
		menu.setLayout(null);		
		
		//Sign In button
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnExit.setBounds(255, 185, 230, 116);
		btnExit.setActionCommand("exit");
		menu.add(btnExit, BorderLayout.CENTER);
		
		//Welcome message + user prompt
		JLabel choosePrompt1 = new JLabel("THANK YOU!");
		JLabel choosePrompt2 = new JLabel("We appreciate it!");
		choosePrompt1.setFont(new Font("SansSerif", Font.BOLD, 50));
		choosePrompt2.setFont(new Font("SansSerif", Font.BOLD, 30));
		choosePrompt1.setBounds(215, 20, 540, 113);
		choosePrompt2.setBounds(250, 70, 540, 113);
		menu.add(choosePrompt1);
		menu.add(choosePrompt2);
		
		//Add Panel to JFrame
		add(menu);
	}
	
	public void actionPerformed(ActionEvent e){
		String text = e.getActionCommand();
		if(text.equals("exit")){
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		ThankYouView window = new ThankYouView();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(760, 425);
		window.setVisible(true);
		window.getMouseListeners();
	}
}
