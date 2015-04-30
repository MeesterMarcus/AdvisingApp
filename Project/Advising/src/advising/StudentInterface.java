package advising;

public interface StudentInterface {

	/**
	 * @return banner id
	 */
	public abstract String getBanner();

	/**
	 * Set the banner id
	 * 
	 * @param s
	 */
	public abstract void setBanner(String s);

	/**
	 * @return first name
	 */
	public abstract String getFName();

	/**
	 * @return last name
	 */
	public abstract String getLName();

	/**
	 * @return DOB
	 */
	public abstract String getDOB();

	/**
	 * @return email
	 */
	public abstract String getEmail();

	/**
	 * Returns yes if the student is scheduled on the waitlist.
	 * 
	 * @return waitlist
	 */
	public abstract boolean isWaitlist();

	/**
	 * Returns the appointment day.
	 * 
	 * @return day
	 */
	public abstract String getDay();

	/**
	 * Returns the appointment time.
	 * 
	 * @return time
	 */
	public abstract String getTime();

	/**
	 * @return student personal information
	 */
	public abstract String toString();

}