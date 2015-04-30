package advising;

import java.awt.event.ActionEvent;

public interface ControllerInterface {

	/**
	 * Check for button selection. If user clicked "Exit" in menu, exit program.
	 * If user clicked submit, check the input fields, and pass the information
	 * to the Student table in the Students Database.
	 */
	public abstract void actionPerformed(ActionEvent e);

}