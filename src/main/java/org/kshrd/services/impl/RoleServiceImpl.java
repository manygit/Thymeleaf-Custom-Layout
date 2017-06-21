package org.kshrd.services.impl;

import java.util.List;

import org.kshrd.model.RoleModel;
import org.kshrd.repositories.RoleRepository;
import org.kshrd.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleModel> getAllRole() {
		return roleRepository.getAllRole();
	}

	@Override
	public boolean deleteRole(int id) {
		return roleRepository.deleteRole(id);
	}

	@Override
	public boolean addRole(RoleModel role) {
		return roleRepository.addRole(role);
	}

	@Override
	public RoleModel findRoleById(int id) {
		return roleRepository.findRoleById(id);
	}

	@Override
	public boolean updateRole(RoleModel role) {
		return roleRepository.updateRole(role);
	}

	@Override
	public int getNextRoleIdToInsert() {
		return roleRepository.getNextRoleIdToInsert();
	}

}
