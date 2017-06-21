package org.kshrd.services.impl;

import java.util.List;

import org.kshrd.model.UserModel;
import org.kshrd.repositories.UserRepository;
import org.kshrd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserModel> getAllUser() {
		return userRepository.getAllUser();
	}

	@Override
	public boolean deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

	@Override
	public boolean addUser(UserModel user) {
		return userRepository.addUser(user);
	}

	@Override
	public UserModel findUserById(int id) {
		return userRepository.findUserById(id);
	}

	@Override
	public boolean updateUser(UserModel user) {
		return userRepository.updateUser(user);
	}

	@Override
	public int getNextUserIdToInsert() {
		return userRepository.getNextUserIdToInsert();
	}

	@Override
	public List<UserModel> findAllUserByName(String name) {
		return userRepository.findAllUserByName(name);
	}

}
