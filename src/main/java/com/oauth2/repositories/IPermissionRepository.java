package com.oauth2.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.entities.Permission;
import com.oauth2.entities.Role;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long>{
	
	public List<Permission> findByRoles(Set<Role> set);

}
