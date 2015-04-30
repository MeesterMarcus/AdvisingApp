package advising;

import java.util.Arrays;

/**
 * This class represents a Student record with information: bannerid, fname,
 * lname, dob, email
 * 
 * @author Marcus Lorenzana
 *
 */

public class Student implements StudentInterface {
	private String personalInfo[] = new String[9];

	public Student() {
		for (int i = 0; i < 8; i++) {
			personalInfo[i] = "";
		}
	}

	public Student(String initPersonal[]) {
		personalInfo = initPersonal;
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getBanner()
	 */
	@Override
	public String getBanner() {
		return personalInfo[0];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#setBanner(java.lang.String)
	 */
	@Override
	public void setBanner(String s) {
		personalInfo[0] = s;
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getFName()
	 */
	@Override
	public String getFName() {
		return personalInfo[1];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getLName()
	 */
	@Override
	public String getLName() {
		return personalInfo[2];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getDOB()
	 */
	@Override
	public String getDOB() {
		return personalInfo[3];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getEmail()
	 */
	@Override
	public String getEmail() {
		return personalInfo[4];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#isWaitlist()
	 */
	@Override
	public boolean isWaitlist() {
		if (personalInfo[5].compareTo("Yes") == 0) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getDay()
	 */
	@Override
	public String getDay() {
		return personalInfo[6];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#getTime()
	 */
	@Override
	public String getTime() {
		return personalInfo[7];
	}

	/* (non-Javadoc)
	 * @see advising.StudentInterface#toString()
	 */
	@Override
	public String toString() {
		return Arrays.toString(personalInfo);
	}

}
