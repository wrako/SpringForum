package com.forum.scoreservice;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@NamedQuery( name = "Score.getTopScores",
        query = "SELECT s FROM Score s WHERE s.game=:game ORDER BY s.points DESC")
@NamedQuery( name = "Score.getScoreById",
        query = "SELECT s FROM Score s WHERE s.game=:game and s.usrId =: usrId")
@NamedQuery( name = "Score.resetScores",
        query = "DELETE FROM Score")

@Table(name = "score", schema = "public")

public class Score{

    @Id
    private Long usrId;

    private int points;

    private Date playedOn;

    private String game;

    public Score(Long usrId, int points, Date playedOn) {
        this.usrId = usrId;
        this.points = points;
        this.playedOn = playedOn;
    }
}
