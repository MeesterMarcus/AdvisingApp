package advising;

import java.sql.*;

public class sqlTest {

	/* DB SCHEMA
	 * create database javaTest;
	 * use javaTest;
     * create table test ( id int, name varchar(255) );
	 */
	
	/* TEST DATA
	 * insert into test values (1, "Matt Kliewer");
	 */

	public static void main(String[] args) {
		//create new SQLInfo object with the supplied connection details
		SQLInfoInterface sqlInfo = new SQLInfo(	"com.mysql.jdbc.Driver",
										"jdbc:mysql://gundam.eu:44531/Students",
										"remote",
										"Team5!!1one");
		try {
			//execute the query and store result in rs
			ResultSet rs = sqlInfo.query("select name,id from test where name like \"Matt%\"");
			//iterate through result (in this case there should only be 1 row)
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				
			}
			
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
