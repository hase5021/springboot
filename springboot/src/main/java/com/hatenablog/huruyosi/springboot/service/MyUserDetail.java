package com.hatenablog.huruyosi.springboot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hatenablog.huruyosi.springboot.entity.Authorities;
import com.hatenablog.huruyosi.springboot.entity.Users;

/**
 * 本システム用 のユーザ情報
 *
 */
public class MyUserDetail implements UserDetails {
	private int userId;
	private String username;
	private String password;
	private String displayName;
	private Collection<GrantedAuthority> authorities;


	public MyUserDetail(int userId, String username, String password,
			String displayName, Collection<GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.authorities = authorities;
	}

	/**
	 * {@link Users}を元にインスタンスを生成します。
	 * @param user 生成元になるユーザ
	 * @return
	 */
	public static UserDetails create(Users entity) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Authorities auth: entity.getAuthorities()){
			authorities.add(new SimpleGrantedAuthority(auth.getId().getAuthority()));
		}
		return new MyUserDetail(entity.getUserId(), entity.getLoginId(), entity.getPassword(), entity.getDisplayName(), authorities);
	}


	/**
	 * 永続化された{@link Users}の{@link Users#getId()}を取得します。
	 * @return
	 */
	public int getUserId(){
		return this.userId;
	}

	/**
	 * 永続化された{@link Users}の{@link Users#getName()}を取得します。
	 * @return
	 */
	public String getDisplayName(){
		return this.displayName;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return this.password;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return this.username;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (非 Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
