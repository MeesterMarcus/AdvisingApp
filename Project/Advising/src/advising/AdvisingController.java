package advising;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a controller for the buttons pressed. Submits student info to
 * database upon clicking "Submit".
 * 
 * @author Marcus Lorenzana
 *
 */

public class AdvisingController implements ActionListener, ControllerInterface {

	private AdvisingModelInterface model;

	/**
	 * Initilaize variables in constructor
	 * 
	 * @param model
	 */
	public AdvisingController(AdvisingModelInterface model) {
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see advising.ControllerInterface#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("Check")) {
			/*
			 * For this one we need to do a try catch. But for now, to test,
			 * enter this as banner id or scan david's card: ;000960991=000311?
			 */
			model.check();
		}

		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Submit")) {
			model.submit();
			System.out.println(); 
			System.out.println("Submitted:");
			System.out.println(model); 
			System.out.println(); 
		}

	}

	

}
