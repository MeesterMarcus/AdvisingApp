package waitlist;

import java.util.ArrayList;

import advising.Student;

public interface WaitlistViewInterface {

	/**
	 * This sets the various JTextPanes to the proper appointments.
	 * 
	 * @param appts
	 */
	public abstract void addAppointments(ArrayList<Student> appts);

	/**
	 * This method removes all appointments from the waitlist.
	 */
	public abstract void clearAppointments();

	/**
	 * Add a MouseListener to listen for mouse clicks.
	 * 
	 * @param controller
	 */
	public abstract void setMouseListener(WaitlistControllerInterface controller);

}