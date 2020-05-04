package com.example.demo.login.domain.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegUser implements UserDetails {
	
	private String userId;
	
	private String password;

	private String userName;
	
	private String role;
	
	//Collection<GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role.equals("ROLE_ADMIN")) {
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
	
	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public String getPassword() {
		return this.password;
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
