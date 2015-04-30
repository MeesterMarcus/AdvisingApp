package advising;

public interface AdvisingViewInterface {

	/**
	 * Get the text that was selected from the yes/no waitlist
	 * radio button. 
	 * @return yes or no
	 */
	public abstract String getSelectedButtonText();

	/**
	 * Get day selection
	 * @return MWF or TR
	 */
	public abstract String getDays();

	/**
	 * Get time selection
	 * @return Morning, Afternoon, Evining
	 */
	public abstract String getTime();

	/**
	 * Set the banner id in the field. 
	 * @param s
	 */
	public abstract void setBanner(String s);

	/**
	 * Set the fname in the field
	 * @param s
	 */
	public abstract void setfName(String s);

	/**
	 * Set the lname in the field
	 * @param s
	 */
	public abstract void setlName(String s);

	/**
	 * Set the DOB in the field
	 * @param s
	 */
	public abstract void setDOB(String s);

	/**
	 * Set the email in the field
	 * @param s
	 */
	public abstract void setEmail(String s);

	/**
	 * Get the personal info from the text fields.
	 * @return personalInfo
	 */
	public abstract String[] getPersonalInfo();

	/**
	 * Register components to controller
	 * @param controller
	 */
	public abstract void registerListener(AdvisingController controller);

}