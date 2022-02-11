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
        if (hasEqualScore())
            return getScoreWhenAll();
        if (isAdvatageForPlayerOne())
            return  "Advantage " + player1Name;
        if (isAdvantageForPlayerTwo())
            return  "Advantage " + player2Name;
        if (isWinForPlayerOne())
            return  "Win for " + player1Name;
        if (isWinForPlayerTwo())
            return  "Win for " + player2Name;
        return getRunningScore();
    }

    private boolean isWinForPlayerTwo() {
        return scorePlayerTwo >= 4 && (scorePlayerOne - scorePlayerTwo) <= -2;
    }

    private boolean isWinForPlayerOne() {
        return scorePlayerOne >= 4 && (scorePlayerOne - scorePlayerTwo) >= 2;
    }

    private boolean isAdvantageForPlayerTwo() {
        return scorePlayerTwo >= 4 && (scorePlayerOne - scorePlayerTwo) == -1;
    }

    private boolean isAdvatageForPlayerOne() {
        return scorePlayerOne >= 4 && (scorePlayerOne - scorePlayerTwo) == 1;
    }

    private boolean hasEqualScore() {
        return scorePlayerOne == scorePlayerTwo;
    }

    private String getRunningScore() {
        return mapPlayerScore(scorePlayerOne) + "-" + mapPlayerScore(scorePlayerTwo);
    }

    private String mapPlayerScore(int tempScore) {
        return switch (tempScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }

    private String getScoreWhenAll() {
        return switch (scorePlayerOne) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
