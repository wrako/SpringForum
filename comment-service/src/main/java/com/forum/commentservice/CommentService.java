package com.forum.commentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService  {

    @Autowired
    private CommentRepository commentRepository;

    public void addComment(Comment comment) throws CommentException {
        commentRepository.save(comment);
    }


    public List<Comment> getComments() throws CommentException {
        return commentRepository.findAll();
    }


//    public void reset() throws CommentException {
//        commentRepository.deleteAll();
//    }


}
