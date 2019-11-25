package com.oauth2.entities;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Transient
	private static final long serialVersionUID = -3668685073592312997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tRoleSeq")
	@SequenceGenerator(name = "tRoleSeq", sequenceName = "tbl_role_seq", allocationSize = 1)
	private Long roleId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinTable(name = "tbl_role_permissions",
	joinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "roleId", foreignKey = @ForeignKey(name = "fk_tbl_role_permissions_role")), 
	inverseJoinColumns = @JoinColumn(
		name = "permission_id", referencedColumnName = "permissionId", foreignKey = @ForeignKey(name = "fk_tbl_role_permissions_permission")))
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
