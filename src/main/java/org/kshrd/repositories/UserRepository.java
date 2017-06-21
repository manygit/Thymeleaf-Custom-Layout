package org.kshrd.repositories;

import java.util.List;

import org.kshrd.model.UserModel;

public interface UserRepository {
	public List<UserModel> getAllUser();
	public boolean deleteUser(int id);
	public boolean addUser(UserModel user);
	public UserModel findUserById(int id);
	public boolean updateUser(UserModel user);
	public int getNextUserIdToInsert();
	public List<UserModel> findAllUserByName(String name);
}
