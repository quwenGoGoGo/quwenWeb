package com.groupeight.quwen.service;

import com.groupeight.quwen.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(Long commentID);

    Comment getCommentByID(Long commentID);
}
