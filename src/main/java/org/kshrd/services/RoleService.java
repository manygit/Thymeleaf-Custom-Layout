package org.kshrd.services;

import java.util.List;

import org.kshrd.model.RoleModel;

public interface RoleService {
	public List<RoleModel> getAllRole();
	public boolean deleteRole(int id);
	public boolean addRole(RoleModel role);
	public RoleModel findRoleById(int id);
	public boolean updateRole(RoleModel role);
	public int getNextRoleIdToInsert();
}
