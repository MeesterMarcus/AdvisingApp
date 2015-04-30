package advising;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class holds records for students. Probably needs more
 * implementation.
 * @author Marcus Lorenzana
 *
 */

public class AdvisingModel implements AdvisingModelInterface {
	private AdvisingView view; 
	private SQLInfoInterface sqlInfo;
	private Statement stmt;
	private String banner,fname,lname,dob,email; 
	
	public AdvisingModel(AdvisingView view,SQLInfoInterface sqlInfo) {
		this.sqlInfo=sqlInfo; 
		this.view = view; 
		this.banner="";
		this.fname="";
		this.lname="";
		this.dob="";
		this.email="";
	}
	
	
	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#toString()
	 */
	@Override
	public String toString() {
		return "["+banner+","+fname+","+lname+","+dob+","+email+"]";
		
	}
	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#ClearFields()
	 */
	@Override
	public void ClearFields() {
		view.bannerField.setText("");
		view.fNameField.setText("");
		view.lNameField.setText("");
		view.dobField.setText("");
		view.emailField.setText("");

	}

	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#isValidBanner(java.lang.String)
	 */
	@Override
	public boolean isValidBanner(String banner) {
		boolean hasAlpha = false;
		try {
			@SuppressWarnings("unused")
			int b = Integer.parseInt(banner);
		} catch (NumberFormatException nfe) {
			hasAlpha = true;
		}

		if (banner.length() != 9 || !banner.substring(0, 3).equals("000")
				|| hasAlpha || banner.isEmpty()) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#check()
	 */
	@Override
	public void check() {
		banner = view.getPersonalInfo()[0];

		// If the card was scanned, it will have semicolons separating
		// the data and needs to be formatted.
		if (banner.contains(";")) {
			System.out.println("Card");
			banner = banner.substring(1, 10);
		} else if (isValidBanner(banner) == false) {
			System.out.println("Invalid Banner ID.");
			ClearFields();
		}

		// Query the database for the banner ID
		String sql_check;
		sql_check = "SELECT * FROM Student where BannerID=" + "\"" + banner
				+ "\"";
		ResultSet rs = sqlInfo.query(sql_check);

		// Retrieve each attribute and set the fields to their corresponding
		// values.
		try {
			while (rs.next()) {
				String bannerCheck = rs.getString("BannerID");
				String fnameCheck = rs.getString("First");
				String lnameCheck = rs.getString("Last");
				String dobCheck = rs.getString("DOB");
				String emailCheck = rs.getString("Email");
				banner = bannerCheck;
				fname = fnameCheck;
				lname = lnameCheck;
				dob = dobCheck;
				email = emailCheck;
				String[] infoFromDB = { bannerCheck, fnameCheck, lnameCheck,
						dobCheck, emailCheck };
				setFieldFromCheck(infoFromDB);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#setFieldFromCheck(java.lang.String[])
	 */
	@Override
	public void setFieldFromCheck(String s[]) {
		view.setBanner(s[0]);
		view.setfName(s[1]);
		view.setlName(s[2]);
		view.setDOB(s[3]);
		view.setEmail(s[4]);
	}

	/* (non-Javadoc)
	 * @see advising.AdvisingModelInterface#submit()
	 */
	@Override
	public void submit() {

		String wl, day, time;
		wl = "";
		day = "";
		time = "";

		// If user selected waitlist, no need for specific appointment time.
		// Add the student to the queue.
		try {
			if (view.getSelectedButtonText().equals("Yes")) {
				wl = view.getSelectedButtonText();
				day = "WL";
				time = "WL";
			}

			else {
				wl = view.getSelectedButtonText();
				day = view.getDays();
				time = view.getTime();
			}
		} catch (NullPointerException npe) {
			System.out.println("No selection for waitlist");

		}

		String[] personalInfo = view.getPersonalInfo();

		StudentInterface newStudent = new Student(personalInfo);

		banner = personalInfo[0];
		fname = personalInfo[1];
		lname = personalInfo[2];
		dob = personalInfo[3];
		email = personalInfo[4];

		if (banner.isEmpty()) {
			System.out.println("Banner is empty.");
			ClearFields();
		}

		// If the user entered a banner id without the leading zeroes,
		// Add the zeroes.
		else if (!banner.substring(0, 3).equals("000")) {
			String leadingzeros = "00";
			banner = leadingzeros + banner;
			newStudent.setBanner(banner);
			System.out.println("Fixed Banner: "+banner);
		}

		// Prepare a new statement
		try {
			stmt = sqlInfo.getConn().createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// First check to make sure the banner id is valid
		if (isValidBanner(banner) == false) {
			System.out.println("Invalid Banner ID.");
			ClearFields();
		} else {
			// Insert if not exists the student and appointment
			String sql, sql2;
			sql = "INSERT IGNORE INTO Student (`BannerID`,`First`,`Last`,`DOB`,`Email`) "
					+ "VALUES (\""
					+ banner
					+ "\",\""
					+ fname
					+ "\",\""
					+ lname
					+ "\",\"" + dob + "\",\"" + email + "\")";
			sql2 = "INSERT IGNORE INTO Appts (`BannerID`,`Waitlist`,`Day`,`Time`) "
					+ "VALUES (\""
					+ banner
					+ "\",\""
					+ wl
					+ "\",\""
					+ day
					+ "\",\"" + time + "\")";
			try {
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ClearFields();
		}
	}

}
