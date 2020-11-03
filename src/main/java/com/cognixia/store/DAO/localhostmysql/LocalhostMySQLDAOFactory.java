
package com.cognixia.store.DAO.localhostmysql;
// AwsMySQL concrete DAO Factory implementation

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognixia.store.DAO.DAOFactory;
import com.cognixia.store.DAO.IProductDAO;
import com.cognixia.store.DAO.IUserDAO;

public class LocalhostMySQLDAOFactory extends DAOFactory {

	// method to create MySQL connections
	public static Connection createConnection() {
		try {
			DriverManager.registerDriver(new );
			return DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to the database", e);
		}
	}

	@Override
	public IUserDAO getCustomerDAO() {
		// LocalhostMySQLCustomerDAO implements CustomerDAO
		return new LocalhostMySQLUserDAO();
	}

	@Override
	public IProductDAO getAccountDAO() {
		return new LocalhostMySQLProductDAO();
	}
}