package org.kshrd.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.kshrd.model.UserModel;
import org.kshrd.repositories.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private List<UserModel> user = new ArrayList<>();
	
	public UserRepositoryImpl() {
		user.add(new UserModel(1, "Many", "Male","yoeurmmany@gmail.com", "Owner"));
		user.add(new UserModel(2, "Kimly", "Male","kimly@gmail.com", "Admin"));
		user.add(new UserModel(3, "MouyKea", "Female","mouykea@gmail.com", "Admin"));
	}
	@Override
	public List<UserModel> getAllUser() {
		return user;
	}

	@Override
	public boolean deleteUser(int id) {
		user.remove(findUserById(id));
		return true;
	}
	@Override
	public boolean addUser(UserModel us) {
		user.add(us);
		return true;
	}
	@Override
	public UserModel findUserById(int id) {
		return user.stream().filter(u->u.getId() == id).findFirst().orElse(new UserModel());
	}
	@Override
	public boolean updateUser(UserModel usr) {
		user.stream().filter(u->u.getId()==usr.getId())
					.forEach(u->{
						u.setName(usr.getName());
						u.setGender(usr.getGender());
						u.setEmail(usr.getEmail());
						u.setRole(usr.getRole());
					});
		return true;
	}
	@Override
	public int getNextUserIdToInsert() {
		UserModel userModel = user.stream().max((u1,u2)->u1.getId()-u2.getId()).orElse(new UserModel());
		if("".equals(userModel.getName())){
			return 1;
		}
		return userModel.getId()+1;
	}
	@Override
	public List<UserModel> findAllUserByName(String name) {
		if("".equals(name)) return new ArrayList<UserModel>();
		return user.stream().filter(u->u.getName().toLowerCase().startsWith(name.toLowerCase())).collect(Collectors.toList());
	}

}
