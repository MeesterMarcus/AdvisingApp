package waitlist;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextPane;

/** 
 * Waitlist controller, unused atm.
 * 
 * @author Matthew Kliewer
 *
 */
public class WaitlistController implements MouseListener, WaitlistControllerInterface {
	
	private WaitlistViewInterface view;
	
	/**
	 * Constructor for the contorller.
	 * 
	 * @param view
	 */
	public WaitlistController(WaitlistViewInterface view) {
		this.view = view;
		
	}
	
	/* (non-Javadoc)
	 * @see waitlist.WaitlistControllerInterface#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent click) {
		MJTextPane pane = (MJTextPane) click.getSource();
		//System.out.println("ID: "+pane.getID()+" \nName: "+pane.getText()+"\nWaitlist: "+pane.isWL());	
	}
	
	/* (non-Javadoc)
	 * @see waitlist.WaitlistControllerInterface#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent click) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see waitlist.WaitlistControllerInterface#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent click) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see waitlist.WaitlistControllerInterface#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent click) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see waitlist.WaitlistControllerInterface#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent click) {
		// TODO Auto-generated method stub
		
	}

}
