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
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/javaTest";
	static final String USER = "root";
	static final String PASS = "test";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "select name from test where id = 1";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println("Name: "+name);
			}
			
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2) {
		    	} try {
		    		if(conn!=null)
		    			conn.close();
		      } catch(SQLException se) {
		    	  se.printStackTrace();
		      }
		}
		
	}

}
