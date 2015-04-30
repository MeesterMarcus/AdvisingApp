package advising;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This project creates a program and a database to store information for
 * student advising. Banner ID should be two leading zeroes, followed by your
 * banner id. So if your banner id is 0123456 It would be 000123456
 * 
 * @author Marcus Lorenzana
 *
 */

public class AdvisingMain {// start of class

	/**
	 * Main function for testing.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {// start of main

		SQLInfoInterface sqlInfo;

		// Create and establish MySQL connection
		sqlInfo = new SQLInfo("com.mysql.jdbc.Driver",
				"jdbc:mysql://gundam.eu:44531/Students", "remote",
				"Team5!!1one");

		setFeel();

		// fname, lname, dob, address, zip, city, state, email
		AdvisingView view = new AdvisingView();
		AdvisingModelInterface model = new AdvisingModel(view, sqlInfo);
		AdvisingController controller = new AdvisingController(model);

		view.registerListener(controller);

		// Set gui size based off of screen resolution
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(width / 4, height / 3);
		view.setVisible(true);


	}// end of main

	/**
	 * Set the look and feel of the GUI to something a bit nicer.
	 */
	public static void setFeel() {// start of setFeel()
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, set to current System's lok and feel
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
		}
	}// end of setFeel()

}// end of class
