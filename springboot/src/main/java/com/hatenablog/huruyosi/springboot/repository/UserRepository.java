package com.hatenablog.huruyosi.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatenablog.huruyosi.springboot.entity.Users;


/**
 * {@lilnk Users}のDAO
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	/**
	 * {@link Users#get
	 * @param loginId
	 * @return
	 */
	public Users findByLoginId(String loginId);
}
