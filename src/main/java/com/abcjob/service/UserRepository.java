package com.abcjob.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcjob.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	@Query(value = "SELECT u FROM User u WHERE concat(u.firstname, \' \', u.lastname) LIKE '%' ||:keyword|| '%' OR u.company LIKE '%' || :keyword || '%' OR u.address LIKE '%' || :keyword || '%'")
	public List<User> search(@Param("keyword") String keyword);
	
	@Query(value = "SELECT u FROM User u WHERE NOT u.applyJob = ''")
	public List<User> listUserApplyJob();
	
	User findByEmail(String email);
	
	User findByToken(String token);
}
