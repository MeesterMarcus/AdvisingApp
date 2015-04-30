package waitlist;

import java.awt.event.MouseEvent;

public interface WaitlistControllerInterface {

	/**
	 * Runs when a mouse click is detected.
	 * Will eventually check for a 'double-click' and then delete the appointment.
	 * 
	 */
	public abstract void mouseClicked(MouseEvent click);

	/**
	 * Runs when Mouse entered.
	 */
	public abstract void mouseEntered(MouseEvent click);

	/**
	 * Runs when Mouse exited.
	 */
	public abstract void mouseExited(MouseEvent click);

	/**
	 * Runs when mouse pressed.
	 */
	public abstract void mousePressed(MouseEvent click);

	/**
	 * Runs when mouse released.
	 */
	public abstract void mouseReleased(MouseEvent click);

}