package com.forum.commentservice;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    void addComment(Comment comment) throws CommentException;
//    List<Comment> getComments(String game) throws CommentException;
//    void reset() throws CommentException;
}
