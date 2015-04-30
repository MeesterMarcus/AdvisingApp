package waitlist;

/**
 * This is the waitlist application. It displays the current scheduled appointments.
 * 
 * @author Matthew Kliewer
 *
 */
public class WaitlistMain {

	/**
	 * main method. Create the view and turn it on!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WaitlistView view = new WaitlistView();
		WaitlistControllerInterface controller = new WaitlistController(view);
		view.setMouseListener(controller);
		
		WaitlistModelInterface model = new WaitlistModel(view);
		
		view.setVisible(true);

	}

}
