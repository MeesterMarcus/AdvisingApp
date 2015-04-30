package advising;

import java.sql.Connection;
import java.sql.ResultSet;

public interface SQLInfoInterface {

	/**
	 * @return JDBC driver string
	 */
	public abstract String getJDBC_DRIVER();

	/**
	 * Set the JDBC driver string
	 * @param JDBC_DRIVER
	 */
	public abstract void setJDBC_DRIVER(String JDBC_DRIVER);

	/**
	 * Get the database URL
	 * @return database URL
	 */
	public abstract String getDB_URL();

	/**
	 * Set the database URL
	 * @param DB_URL
	 */
	public abstract void setDB_URL(String DB_URL);

	/**
	 * @return username
	 */
	public abstract String getUSER();

	/**
	 * Set the username
	 * @param USER
	 */
	public abstract void setUSER(String USER);

	/**
	 * @return password
	 */
	public abstract String getPASS();

	/**
	 * Set the password
	 * @param PASS
	 */
	public abstract void setPASS(String PASS);

	/**
	 * @return connection
	 */
	public abstract Connection getConn();

	/**
	 * Establish connection
	 * @param conn
	 */
	public abstract void setConn(Connection conn);

	/**
	 * Execute a query
	 * @param query
	 * @return query
	 */
	public abstract ResultSet query(String query);

}