package com.forum.scoreservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
//    void addScore(Score score) throws ScoreException;
//
//    void updateScore(Score score) throws ScoreException;
//    List<Score> getTopScores(String game) throws ScoreException;
//    void reset() throws ScoreException;
//
//    Score getScoreById(String game, Long id);
}
