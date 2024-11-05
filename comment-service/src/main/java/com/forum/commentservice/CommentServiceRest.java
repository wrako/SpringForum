package com.forum.commentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentServiceRest {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @PostMapping
    public void addComment(@RequestBody CommentRequest commentRequest, @RequestHeader("X-User-Id") String userId) {
        Long userIdLong = Long.parseLong(userId); // Преобразуем userId в Long
//        System.out.println("---------------------------------------------------------");
//        System.out.printf(userIdLong.toString());
//        System.out.println("---------------------------------------------------------");
        Comment comment = new Comment(userIdLong, commentRequest.getCommentText(), new Date());
        commentService.addComment(comment);
    }

}
