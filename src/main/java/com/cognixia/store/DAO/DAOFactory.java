
package com.cognixia.store.DAO;

import com.cognixia.store.DAO.localhostmysql.LocalhostMySQLDAOFactory;

//Abstract class DAO Factory
public abstract class DAOFactory {

	// List of DAO types supported by the factory
	public static final int LOCALHOST_MYSQL = 1;
	
	// There will be a method for each DAO that can be 
	// created. The concrete factories will have to 
	// implement these methods.
	public abstract IUserDAO getCustomerDAO();
	public abstract IProductDAO getAccountDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case LOCALHOST_MYSQL: 
	        return new LocalhostMySQLDAOFactory();
	    default: 
	        return null;
		}
	}
}