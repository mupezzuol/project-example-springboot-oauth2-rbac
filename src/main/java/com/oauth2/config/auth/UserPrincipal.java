package com.oauth2.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
    	String[] permissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> permission.getName())
                .toArray(String[]::new);
    	
    	//String[] oi = vortarA();
        return AuthorityUtils.createAuthorityList(permissions);
    }

    //TESTEEEEE PRO TAMANHO DO TOKEEEN 
    private String[] vortarA() {
    	String [] permm = new String[300];
    	permm[0] = "user_delete";
    	for (int i = 1; i < 300; i++) {
    		permm[i] = "ab"+i;
		}
		return permm;
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
