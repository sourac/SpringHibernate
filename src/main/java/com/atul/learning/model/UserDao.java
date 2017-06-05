package com.atul.learning.model;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);

}
