package com.utad.barriforinitework3.Fortnite;

public class GeneralDataFortnite {


    //Cogemos del apartado score los datos que queremos coger y como son muchos, le decimos a rankfortnite de donde cogerlos
    private RankFortnite score;
    private RankFortnite scorePerMatch;
    private RankFortnite matches;
    private RankFortnite kills;

    public RankFortnite getScore() {
        return score;
    }

    public void setScore(RankFortnite score) {
        this.score = score;
    }

    public RankFortnite getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(RankFortnite scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public RankFortnite getMatches() {
        return matches;
    }

    public void setMatches(RankFortnite matches) {
        this.matches = matches;
    }

    public RankFortnite getKills() {
        return kills;
    }

    public void setKills(RankFortnite kills) {
        this.kills = kills;
    }
}

