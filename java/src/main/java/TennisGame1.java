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
        return switch (tempScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }

    private String getAdvantageOrWinner() {
        return switch (scorePlayerOne - scorePlayerTwo){
            case 1 -> "Advantage " + player1Name;
            case -1 -> "Advantage " + player2Name;
            case 2 -> "Win for " +  player1Name;
            default -> "Win for " + player2Name;
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
