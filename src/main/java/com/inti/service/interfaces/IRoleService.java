package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Role;

public interface IRoleService {
	public List<Role> findAll();

	public Role findOne(Long idRole);

	public Role save(Role role);

	public void delete(Long idRole);
}
