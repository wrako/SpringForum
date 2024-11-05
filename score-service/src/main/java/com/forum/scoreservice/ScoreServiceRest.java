package com.forum.scoreservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score")
public class ScoreServiceRest {

    @Autowired
    private ScoreService scoreService;

    @GetMapping()
    public List<Score> getTopScores() {
        return scoreService.getTopScores();
    }

    @GetMapping("/{usrId}")
    public Score getScoreById(@PathVariable Long usrId) {
        return scoreService.getScoreById(usrId);
    }

    @PostMapping("/add") // Уникальный маппинг для метода добавления
    public void addScore(@RequestBody Score score) {
        scoreService.addScore(score);
    }
}