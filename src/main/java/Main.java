import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to rock-scissor-paper game");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player1 choice(rock, scissor or paper)");
        String player1 = sc.nextLine();
        Game.checker(player1);

        System.out.println("Enter player2 choice(rock, scissor or paper)");
        String player2 = sc.nextLine();
        Game.checker(player2);

        System.out.println(Game.judge(player1, player2));
    }
}