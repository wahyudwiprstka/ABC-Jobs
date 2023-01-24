package com.abcjob.service;

import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;

@Repository
public interface ThreadRepository extends CrudRepository<Thread, Long> {
	@Modifying
	@Query(value = "DELETE FROM Thread t WHERE t.user = :keyword")
	public void deleteThreadFK(@Param("keyword")User keyword);
}
