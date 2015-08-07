package com.hatenablog.huruyosi.springboot.entity.type;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.hatenablog.huruyosi.springboot.entity.Authorities;


/**
 * {@link Authorities}の主キー
 *
 */
@Embeddable
public class AuthoritiesId implements Serializable {

	private int user_id;
	private String authority;

	public AuthoritiesId() {
	}

	/** コンストラクタ */
	public AuthoritiesId(int user_id, String authority) {
		super();
		this.user_id = user_id;
		this.authority = authority;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthoritiesId other = (AuthoritiesId) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

}
