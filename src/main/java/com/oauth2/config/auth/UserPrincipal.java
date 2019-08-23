package com.oauth2.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.oauth2.entities.User;


public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final User user;
	
    private final Collection<? extends GrantedAuthority> authorities;
	
	
	public UserPrincipal(User user) {
        this.user = user;
        String[] permissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> permission.getName())
                .toArray(String[]::new);
        this.authorities = AuthorityUtils.createAuthorityList(permissions);
    }
	
	
	public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
