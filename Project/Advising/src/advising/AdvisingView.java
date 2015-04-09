package advising;

import javax.swing.*; 

import java.awt.*;
import java.awt.event.ActionListener;

public class AdvisingView extends JFrame{
	
	private JPanel panelCenter;
	private JPanel panelSouth; 
	
	private JMenu menu; 
	private Font font; 
	private JButton submit = new JButton("Submit"); 
	
	JTextField bannerField; 
	JTextField fNameField;
	JTextField lNameField;
	JTextField dobField;
	JTextField addressField;
	JTextField cityField;
	JTextField stateField;
	JTextField zipField;
	JTextField emailField;
	
	public AdvisingView() {
		super("Clinic"); 
		font = new Font("SansSerif",Font.BOLD,20); 
		
		//Create The Menu
		
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
		
		menu = new JMenu("Menu"); 
		menuBar.add(menu); 
		
		JMenuItem exitButton = new JMenuItem("Exit"); 
		menu.add(exitButton); 
		
		//Create The Fields
		panelCenter = new JPanel(); 
		add(panelCenter, BorderLayout.CENTER); 
		
		panelCenter.setLayout(new GridLayout(9,2));

		
		//fname, lname,  dob, address, zip, city, state, email
		JLabel bannerLabel = new JLabel("Banner ID:"); 
		bannerField = new JTextField("");
		panelCenter.add(bannerLabel); 
		panelCenter.add(bannerField);
		
		JLabel fNameLabel = new JLabel("First Name:"); 
		fNameField = new JTextField("");
		panelCenter.add(fNameLabel); 
		panelCenter.add(fNameField);
		
		JLabel lNameLabel = new JLabel("Last Name:"); 
		lNameField = new JTextField("");
		panelCenter.add(lNameLabel); 
		panelCenter.add(lNameField);
		
		JLabel dobLabel = new JLabel("Date of Birth:"); 
		dobField = new JTextField("");
		panelCenter.add(dobLabel); 
		panelCenter.add(dobField);
		
		JLabel addressLabel = new JLabel("Address:"); 
		addressField = new JTextField("");
		panelCenter.add(addressLabel); 
		panelCenter.add(addressField);
		
		JLabel cityLabel = new JLabel("City:"); 
		cityField = new JTextField("");
		panelCenter.add(cityLabel); 
		panelCenter.add(cityField);
		
		JLabel stateLabel = new JLabel("State:"); 
		stateField = new JTextField("");
		panelCenter.add(stateLabel); 
		panelCenter.add(stateField);
		
		JLabel zipLabel = new JLabel("Zip:"); 
		zipField = new JTextField("");
		panelCenter.add(zipLabel); 
		panelCenter.add(zipField);
		
		JLabel emailLabel = new JLabel("Email:"); 
		emailField = new JTextField("");
		panelCenter.add(emailLabel); 
		panelCenter.add(emailField);
		
		panelSouth = new JPanel(); 
		add(panelSouth, BorderLayout.SOUTH); 
		panelSouth.add(submit); 
		
		
	}
	
	public String[] getPersonalInfo(){
		String personalInfo[] = new String[9];
		personalInfo[0] = bannerField.getText(); 
		personalInfo[1] = fNameField.getText(); 
		personalInfo[2] = lNameField.getText(); 
		personalInfo[3] = dobField.getText(); 
		personalInfo[4] = addressField.getText(); 
		personalInfo[5] = cityField.getText(); 
		personalInfo[6] = stateField.getText(); 
		personalInfo[7] = zipField.getText(); 
		personalInfo[8] = emailField.getText(); 
		return personalInfo; 
	}
	
	
	
	public void registerListener(AdvisingController controller) {
		Component[] components = panelSouth.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
		
		

		components = menu.getMenuComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
		
		
	}

}
