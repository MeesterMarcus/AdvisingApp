package waitlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import advising.SQLInfoInterface;
import advising.Student;
import advising.SQLInfo;

/**
 * This is the WaitlistModel class, it handles fetching the students to be displayed on the Waitlist.
 * 
 * @author Matthew Kliewer
 *
 */
public class WaitlistModel implements WaitlistModelInterface {
	
	private ArrayList<Student> students = new ArrayList<Student>();
	private SQLInfoInterface sqlInfo;
	private WaitlistViewInterface view;
	//Select students who have an appointment.
	//"select * from Student join Appts on Student.BannerID=Appts.BannerID" 
	public WaitlistModel(WaitlistViewInterface view) {
		Timer timer = new Timer();
		//Create and establish MySQL connection
		this.sqlInfo = new SQLInfo(
				"com.mysql.jdbc.Driver",
				"jdbc:mysql://gundam.eu:44531/Students",
				"remote",
				"Team5!!1one"
		);
		
		this.view = view;
		updateWailist();
		
		//Timer to update the waitlist every 5 seconds. 
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				updateWailist();
			}
		}, 5*1000, 5*1000);
		
	}
	
	/* (non-Javadoc)
	 * @see waitlist.WaitlistModelInterface#updateWailist()
	 */
	@Override
	public void updateWailist() {
		ResultSet rs;
		
		this.students.clear();
		rs = sqlInfo.query("select * from Student join Appts on Student.BannerID=Appts.BannerID");
		
		try {
			while(rs.next()) {
				String studentInfo[] = new String[9];
				studentInfo[0] = rs.getString("BannerID");
				studentInfo[1] = rs.getString("First");
				studentInfo[2] = rs.getString("Last");
				studentInfo[3] = rs.getString("DOB");
				studentInfo[4] = rs.getString("Email");
				studentInfo[5] = rs.getString("Waitlist");
				studentInfo[6] = rs.getString("Day");
				studentInfo[7] = rs.getString("Time");
				students.add(new Student(studentInfo));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.clearAppointments();
		view.addAppointments(students);
	}

}
