package waitlist;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 * Extend JTextPane to add a ID field.
 * 
 * @author Matthew Kliewer
 *
 */
public class MJTextPane extends JTextPane {

	private String ID;
	private boolean wl;
	
	/**
	 * Contrustor
	 * 
	 */
	public MJTextPane() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with a preset StyledDocument
	 * 
	 * @param doc
	 */
	public MJTextPane(StyledDocument doc) {
		super(doc);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Set the id;
	 * 
	 * @param id
	 */
	public void setID(String id) {
		this.ID = id;
	}
	
	/**
	 * Get the id.
	 * 
	 * @return ID of the pane
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * Set the waitlist status.
	 * @param wl
	 */
	public void setWL(boolean wl) {
		this.wl = wl;
	}
	
	/**
	 * Get the waitlist status.
	 * @return true/false
	 */
	public boolean isWL() {
		return this.wl;
	}

}
