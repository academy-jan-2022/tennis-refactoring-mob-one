import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        if (scorePlayerOne == scorePlayerTwo)
            return getScoreWhenAll();

        if (scorePlayerOne >=4 || scorePlayerTwo >=4)
            return getAdvantageOrWinner();

        return getRunningScore();
    }

    private String getRunningScore() {
        return mapPlayerScore(scorePlayerOne) + "-" + mapPlayerScore(scorePlayerTwo);
    }

    private String mapPlayerScore(int tempScore) {
        switch(tempScore)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getAdvantageOrWinner() {
        String score;
        int minusResult = scorePlayerOne - scorePlayerTwo;
        if (minusResult==1) score ="Advantage " + player1Name;
        else if (minusResult ==-1) score ="Advantage " + player2Name;
        else if (minusResult>=2) score = "Win for " + player1Name;
        else score ="Win for " + player2Name;
        return score;
    }

    private String getScoreWhenAll() {
        String score;
        switch (scorePlayerOne)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}
