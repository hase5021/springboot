package com.hatenablog.huruyosi.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hatenablog.huruyosi.springboot.entity.Users;
import com.hatenablog.huruyosi.springboot.repository.UserRepository;




/**
 * DBを参照してユーザ情報を提供します。
 *
 */
@Component
public class JdbcUserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		if ( username == null || username.isEmpty() ){
			throw new UsernameNotFoundException("username is empty");
		}

		Users foundUser = userRepository.findByLoginId(username);
		if( foundUser != null ){
			return foundUser.toMyUserDetail();
		}
		throw new UsernameNotFoundException( username + "is not found");
	}
}
