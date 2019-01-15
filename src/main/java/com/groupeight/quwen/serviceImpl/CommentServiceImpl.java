package com.groupeight.quwen.serviceImpl;

import com.groupeight.quwen.entity.Comment;
import com.groupeight.quwen.repository.CommentRepository;
import com.groupeight.quwen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentID) {
        commentRepository.deleteById(commentID);
    }

    @Override
    public Comment getCommentByID(Long commentID) {
        return commentRepository.findById(commentID).get();
    }
}
