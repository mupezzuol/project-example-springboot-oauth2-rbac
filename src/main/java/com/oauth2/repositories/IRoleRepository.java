package com.oauth2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	//public List<Role> findByRoles(Set<Role> set);

}
