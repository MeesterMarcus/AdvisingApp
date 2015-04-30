package advising;

import javax.swing.*;

import java.awt.*;
import java.util.Enumeration;

/**
 * This class creates the view for the Advising student submission
 * form.
 * @author Marcus Lorenzana
 *
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class AdvisingView extends JFrame implements AdvisingViewInterface {

	private JPanel panelCenter;
	private JPanel panelSouth;
	private JPanel panelNorth;  

	private JMenu menu;
	private Font font;
	private JButton submit;
	private JButton check; 

	JTextField bannerField;
	JTextField fNameField;
	JTextField lNameField;
	JTextField dobField;
	JTextField emailField;
	
	
	JComboBox timesList; 
	JComboBox daysList; 
	
	JRadioButton yes; 
	JRadioButton no; 
	
	private JPanel groupPanel = new JPanel(); 
	
	ButtonGroup group = new ButtonGroup(); 
	
	 

	/**
	 * Create panels and buttons for form.
	 */
	@SuppressWarnings("unchecked")
	public AdvisingView() {
		super("Student Form");
		
		//Day and time selection 
		String[] days = {"MWF","TR"};
		String[] times = {"Morning","Afternoon","Evening"};
		
		timesList = new JComboBox(times); 
		daysList = new JComboBox(days); 
		
	
		//Add yes or no selection buttons. 
		//Can only select one or the other.
		yes = new JRadioButton("Yes");
		no = new JRadioButton("No"); 
		
		groupPanel.add(yes);
		groupPanel.add(no); 
		
		group.add(yes); 
		group.add(no);
		
		font = new Font("SansSerif", Font.BOLD, 20);

		// Create The Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menu = new JMenu("Menu");
		menuBar.add(menu);

		JMenuItem exitButton = new JMenuItem("Exit");
		menu.add(exitButton);

		// Create the center panel, which consists of
		//fname,lname,dob,email labels and fields. Also the 
		//timeList,daysList,and waitlist yes/no
		panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);

		panelCenter.setLayout(new GridLayout(6, 2));
		
		//Create the north panel which consists of 
		//Banner label, banner field, and check button. 
		panelNorth = new JPanel(); 
		add(panelNorth,BorderLayout.NORTH);
		
		panelNorth.setLayout(new GridLayout(1,3));
		
		//Create and add fields and labels for the form
		JLabel bannerLabel = new JLabel("Banner ID:");
		bannerField = new JTextField("");
		panelNorth.add(bannerLabel);
		panelNorth.add(bannerField);
		check = new JButton("Check");
		panelNorth.add(check);

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

		JLabel emailLabel = new JLabel("Email:");
		emailField = new JTextField("");
		panelCenter.add(emailLabel);
		panelCenter.add(emailField);
		
		//Add time selection and day selection preference dropdown
		panelCenter.add(timesList); 
		panelCenter.add(daysList); 
		
		//Add the waitlist label and radio button
		JLabel checkLabel = new JLabel("Waitlist?"); 
		panelCenter.add(checkLabel); 
		panelCenter.add(groupPanel); 

		//Add the submit button
		submit = new JButton("Submit");
		panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(submit);

	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#getSelectedButtonText()
	 */
	@Override
	public String getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#getDays()
	 */
	@Override
	public String getDays(){
		return (String)daysList.getSelectedItem(); 
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#getTime()
	 */
	@Override
	public String getTime(){
		return (String)timesList.getSelectedItem(); 
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#setBanner(java.lang.String)
	 */
	@Override
	public void setBanner(String s){
		bannerField.setText(s); 
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#setfName(java.lang.String)
	 */
	@Override
	public void setfName(String s) {
		fNameField.setText(s);
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#setlName(java.lang.String)
	 */
	@Override
	public void setlName(String s) {
		lNameField.setText(s);
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#setDOB(java.lang.String)
	 */
	@Override
	public void setDOB(String s){
		dobField.setText(s);
	}
	
	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String s){
		emailField.setText(s);
	}

	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#getPersonalInfo()
	 */
	@Override
	public String[] getPersonalInfo() {
		String personalInfo[] = new String[5];
		personalInfo[0] = bannerField.getText();
		personalInfo[1] = fNameField.getText();
		personalInfo[2] = lNameField.getText();
		personalInfo[3] = dobField.getText();
		personalInfo[4] = emailField.getText();
		return personalInfo;
	}
	

	/* (non-Javadoc)
	 * @see advising.AdvisingViewInterface#registerListener(advising.AdvisingController)
	 */
	@Override
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
		
		components = panelNorth.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
		
		components = groupPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}

	}
	
	

}
