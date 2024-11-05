package com.forum.scoreservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public void addScore(Score score) throws ScoreException {
        scoreRepository.save(score);
    }


    public List<Score> getTopScores() throws ScoreException {
        return scoreRepository.findAll();
    }


    public void reset() {
        scoreRepository.deleteAll();
    }

    public Score getScoreById(Long usrId){
        return scoreRepository.findById(usrId).orElse(null);
    }
}


