package ss8.Bai_tap;

public class TennisGame {
    private static final String ZERO_SCORE = "Love";
    private static final String ONE_SCORE = "Fifteen";
    private static final String TWO_SCORE = "Thirty";
    private static final String THREE_SCORE = "Forty";
    private static final String ALL = "All";
    private static final String WIN = "Win";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage";


    public static String getScore(String player1Name, String player2Name, int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) {
            return displayDeuce(playerOneScore);
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return displayAdvantageOrWin(player1Name, player2Name, playerOneScore, playerTwoScore);
        } else {
            return displayScore(playerOneScore,playerTwoScore);
        }
    }

    private static String displayDeuce(int score) {
        return translateScore(score) + "-" + ALL;
    }

    private static String translateScore(int score) {
        switch (score) {
            case 0:
                return ZERO_SCORE;
            case 1:
                return ONE_SCORE;
            case 2:
                return TWO_SCORE;
            case 3:
                return THREE_SCORE;
            default:
                return DEUCE;

        }
    }

    private static String displayAdvantageOrWin(String player1Name, String player2Name, int playerOneScore, int playerTwoScore) {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) return "Advantage " + " " + player1Name;
        else if (minusResult == -1) return "Advantage " + " " + player2Name;
        else if (minusResult >= 2) return "Win " + " " + player2Name;
        else return "Win " + " " + player1Name;
    }

    private static String displayScore(int playerOneScore, int playerTwoScore) {
        return translateScore(playerOneScore) + "-" + translateScore(playerTwoScore);
    }
}
