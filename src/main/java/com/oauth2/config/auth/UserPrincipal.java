package com.oauth2.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oauth2.entities.User;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	public UserPrincipal(User user) {
        this.user = user;
    }
	
	public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//    	String[] permissions = user.getRoles().stream()
//                .flatMap(role -> role.getPermissions().stream())
//                .map(permission -> permission.getName())
//                .toArray(String[]::new);
//    	AuthorityUtils.createAuthorityList(permissions);
        return null;
    }

	@Override
    public String getPassword() {
        return user.getPassword();
    }

	//UUID -> User
    @Override
    public String getUsername() {
        return user.getUuid().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
