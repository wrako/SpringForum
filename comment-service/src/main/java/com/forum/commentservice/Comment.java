package com.forum.commentservice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@NamedQuery( name = "Comment.getComments",
        query = "SELECT c FROM Comment c ORDER BY c.commentedOn DESC")
@NamedQuery( name = "Comment.resetComments",
        query = "DELETE FROM Comment")

@Table(name = "comment", schema = "public")

public class Comment {
    @Id
    @GeneratedValue
    private Long comId;

    private Long usrId;

    private String comment;

    private Date commentedOn;

    public Comment(Long usrId, String comment, Date commentedOn) {
        this.usrId = usrId;
        this.comment = comment;
        this.commentedOn = commentedOn;
    }

}

