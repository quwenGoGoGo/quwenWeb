package com.groupeight.quwen.repository;

import com.groupeight.quwen.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
