package com.hatenablog.huruyosi.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hatenablog.huruyosi.springboot.entity.type.AuthoritiesId;

/**
 * authoritiesテーブルのエンティティ
 *
 */
@Entity
@Table(name="authorities")
public class Authorities {

	@Id
	private AuthoritiesId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users user;

	public Authorities() {
	}

	/** コンストラクタ */
	public Authorities(AuthoritiesId id){
		this.id = id;
	}

	public AuthoritiesId getId() {
		return id;
	}

	public void setId(AuthoritiesId id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
