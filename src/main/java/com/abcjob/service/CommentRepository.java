package com.abcjob.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcjob.bean.Comment;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	@Modifying
	@Query(value = "DELETE FROM Comment c WHERE c.user = :keyword")
	public void deleteCommentFK(@Param("keyword")User keyword);
}
