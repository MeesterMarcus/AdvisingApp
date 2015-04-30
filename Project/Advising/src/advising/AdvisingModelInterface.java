package advising;

public interface AdvisingModelInterface {

	/**
	 * Print student information to console.
	 */
	public abstract String toString();

	/**
	 * Clear the text fields after submission.
	 */
	public abstract void ClearFields();

	/**
	 * Check if it is a valid banner id
	 * 
	 * @param banner
	 * @return
	 */
	public abstract boolean isValidBanner(String banner);

	/**
	 * Check the database to see if this banner id exists. If it does, fill out
	 * the rest of the form using the data retrieved from the database.
	 */
	public abstract void check();

	/**
	 * Sets the fields to the values found in the database.
	 * 
	 * @param s
	 */
	public abstract void setFieldFromCheck(String s[]);

	/**
	 * If the student does not exist in the database, add them to it. Add the
	 * appointment to the appointment database.
	 */
	public abstract void submit();

}