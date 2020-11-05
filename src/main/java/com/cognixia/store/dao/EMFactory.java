package com.cognixia.store.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebStore");
	
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
}
