package org.kshrd.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.kshrd.model.RoleModel;
import org.kshrd.repositories.RoleRepository;
import org.springframework.stereotype.Repository;


@Repository
public class RoleRepositoryImpl implements RoleRepository{

	private List<RoleModel> roleList = new ArrayList<>();
	
	public RoleRepositoryImpl() {
		roleList.add(new RoleModel(1, "Owner", "The one own the company"));
		roleList.add(new RoleModel(2, "Admin", "The one who can control all transation"));
		roleList.add(new RoleModel(3, "Normal User", "Normal Employee"));
	}
	
	@Override
	public List<RoleModel> getAllRole() {
		return roleList;
	}
	@Override
	public boolean deleteRole(int id) {
		roleList.remove(findRoleById(id));
		return true;
	}
	@Override
	public boolean addRole(RoleModel role) {
		roleList.add(role);
		return true;
	}
	@Override
	public RoleModel findRoleById(int id) {
		return roleList.stream().filter(u->u.getId() == id).findFirst().orElse(new RoleModel());
	}
	@Override
	public boolean updateRole(RoleModel role) {
		roleList.stream().filter(r->r.getId()==role.getId())
		.forEach(r->{
			r.setRoleName(role.getRoleName());
			r.setDescription(role.getDescription());
		});
		return true;
	}
	@Override
	public int getNextRoleIdToInsert() {
		RoleModel roleModel = roleList.stream().max((r1,r2)->r1.getId()-r2.getId()).orElse(new RoleModel());
		if("".equals(roleModel.getRoleName())){
			return 1;
		}
		return roleModel.getId()+1;
	}

}
