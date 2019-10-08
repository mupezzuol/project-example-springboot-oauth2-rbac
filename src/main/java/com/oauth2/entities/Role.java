package com.oauth2.entities;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "RoleEntity")
@Table(name = "tbl_role")
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long roleId;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinTable(name = "tbl_role_permissions",
	joinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "roleId"), 
	inverseJoinColumns = @JoinColumn(
		name = "permission_id", referencedColumnName = "permissionId"))
	private Set<Permission> permissions;
	
	@ManyToMany(mappedBy = "roles")
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<User> users;

	@Override
	public String getAuthority() {
		return this.permissions.stream()
	        	.map( p -> p.getName())
	        	.collect(Collectors.joining(","));
	}

	@Override
    public int hashCode() {
        if (roleId != null) {
            return roleId.hashCode();
        } else if (name != null) {
            return name.hashCode();
        }

        return 0;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null || !(another instanceof Role))
            return false;
        Role anotherRole = (Role) another;
        return anotherRole.roleId != null && (anotherRole.roleId == this.roleId);
    }

    @Override
    public String toString() {
        return name;
    }


	public Role(String name) {
		this.name = name;
	}
    
}
