package org.kshrd.services;

import java.util.List;

import org.kshrd.model.UserModel;

public interface UserService {
	public List<UserModel> getAllUser();
	public boolean deleteUser(int id);
	public boolean addUser(UserModel user);
	public UserModel findUserById(int id);
	public boolean updateUser(UserModel user);
	public int getNextUserIdToInsert();
	public List<UserModel> findAllUserByName(String name);
}
