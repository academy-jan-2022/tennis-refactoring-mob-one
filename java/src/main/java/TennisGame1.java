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
        int scoreDifference = scorePlayerOne - scorePlayerTwo;
        if (scoreDifference == 1) return "Advantage " + player1Name;
        if (scoreDifference == -1) return"Advantage " + player2Name;
        if (scoreDifference >= 2) return "Win for " + player1Name;
        return "Win for " + player2Name;
    }

    private String getScoreWhenAll() {
        switch (scorePlayerOne) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
