package com.cognixia.store.dao;

import java.util.List;

import com.cognixia.store.models.User;

public interface CustomerDB {

	public User getByEmail(String email);
	public List<User> getAllUsers();
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
	public boolean emailExists(String email);
}
