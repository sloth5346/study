package com.example.demo.login.domain.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.RegUser;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.mybatis.RegUserMapper;


// ログイン時に使用するサービスクラス *

@Service
public class LoginService implements UserDetailsService  {
	
	@Autowired
	RegUserMapper regUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		if (userId == null || "".equals(userId)) {
		     throw new UsernameNotFoundException("UserId is empty");
		 }
		
		 RegUser regUser = regUserMapper.selectByUserId(userId);
		 if (regUser == null) {
		     throw new UsernameNotFoundException("User not found: " + userId);
		 }
		 
		 return regUser;
		
	}
}
