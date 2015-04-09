package advising;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdvisingController implements ActionListener {
	
	private AdvisingModel model; 
	private AdvisingView view; 
	private JButton submitButton; 
	
	public AdvisingController(AdvisingModel model, AdvisingView view) {
		this.model = model;
		this.view = view; 
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand(); 
		
		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Submit")){
			Student newStudent = new Student(view.getPersonalInfo()); 
			model.addStudent(newStudent); 
			System.out.println(model); 
			ClearFields(); 
			
		}
		
	}
	

	public void ClearFields() {
		view.bannerField.setText("");
		view.fNameField.setText("");
		view.lNameField.setText("");
		view.dobField.setText("");
		view.addressField.setText("");
		view.cityField.setText("");
		view.stateField.setText("");
		view.zipField.setText("");
		view.emailField.setText("");
		
	}

}
