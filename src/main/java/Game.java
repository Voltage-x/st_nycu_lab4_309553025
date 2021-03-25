public class Game {
    public static void checker(String input) {
        if (!input.equals("rock") && !input.equals("scissor") && !input.equals("paper")) {
            throw new IllegalArgumentException("Bad choice :( ");
        }
    }

    public static String judge(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Draw!";
        } else if ((player1.equals("rock") && player2.equals("scissor")) ||
                (player1.equals("scissor") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "Player1 win!";
        } else {
            return "Player2 win!";
        }
    }
}
