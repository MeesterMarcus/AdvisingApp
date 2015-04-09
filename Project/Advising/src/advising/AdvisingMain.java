package advising;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class AdvisingMain {

	public static void main(String[] args) {
	
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		//fname, lname,  dob, address, zip, city, state, email
		AdvisingModel model = new AdvisingModel(); 
		AdvisingView view = new AdvisingView(); 
		AdvisingController controller = new AdvisingController(model,view); 
		
		view.registerListener(controller); 
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400,540);
		view.setVisible(true); 
		
		System.out.println(model); 

	}

}
