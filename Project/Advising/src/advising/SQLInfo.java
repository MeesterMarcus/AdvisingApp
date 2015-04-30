package advising;

import java.sql.*;

/**
 * This class contains all information for MySQL database
 * communication and establishes connections. It will also handle
 * execution of statements. 
 * @author Marcus Lorenzana
 * @author Matt Kliewer
 */


public class SQLInfo implements SQLInfoInterface {
	
	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;
	private Connection conn;

	/**
	 * Initialize variables and establish connection.
	 * @param JDBC
	 * @param url
	 * @param usr
	 * @param pass
	 */
	public SQLInfo(String JDBC, String url, String usr, String pass) {
		this.JDBC_DRIVER = JDBC;
		this.DB_URL = url;
		this.USER = usr;
		this.PASS = pass;

		// load the mysql driver
		try {
			Class.forName(this.JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		// since the user opted to supply connection details, create the
		// conneciton...
		try {
			this.conn = DriverManager.getConnection(this.DB_URL, this.USER,
					this.PASS);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public SQLInfo() {
		JDBC_DRIVER = "";
		DB_URL = "";
		USER = "";
		PASS = "";
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#getJDBC_DRIVER()
	 */
	@Override
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#setJDBC_DRIVER(java.lang.String)
	 */
	@Override
	public void setJDBC_DRIVER(String JDBC_DRIVER) {
		this.JDBC_DRIVER = JDBC_DRIVER;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#getDB_URL()
	 */
	@Override
	public String getDB_URL() {
		return DB_URL;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#setDB_URL(java.lang.String)
	 */
	@Override
	public void setDB_URL(String DB_URL) {
		this.DB_URL = DB_URL;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#getUSER()
	 */
	@Override
	public String getUSER() {
		return USER;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#setUSER(java.lang.String)
	 */
	@Override
	public void setUSER(String USER) {
		this.USER = USER;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#getPASS()
	 */
	@Override
	public String getPASS() {
		return PASS;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#setPASS(java.lang.String)
	 */
	@Override
	public void setPASS(String PASS) {
		this.PASS = PASS;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#getConn()
	 */
	@Override
	public Connection getConn() {
		return conn;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#setConn(java.sql.Connection)
	 */
	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/* (non-Javadoc)
	 * @see advising.SQLInfoInterface#query(java.lang.String)
	 */
	@Override
	public ResultSet query(String query) {
		ResultSet rs;
		Statement stmt;
		try {
			stmt = this.getConn().createStatement();
			rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
	}

}
