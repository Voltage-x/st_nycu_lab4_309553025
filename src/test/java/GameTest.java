import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    static Stream<Arguments> player1WinListProvider() {
        return Stream.of(
                Arguments.of("scissor", "paper"),
                Arguments.of("paper", "rock"),
                Arguments.of("rock", "scissor")
        );
    }

    static Stream<Arguments> player2WinListProvider() {
        return Stream.of(
                Arguments.of("scissor", "rock"),
                Arguments.of("rock", "paper"),
                Arguments.of("paper", "scissor")
        );
    }

    static Stream<Arguments> DrawListProvider() {
        return Stream.of(
                Arguments.of("scissor", "scissor"),
                Arguments.of("rock", "rock"),
                Arguments.of("paper", "paper")
        );
    }

    Game game = new Game();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"paper", "scissor", "rock"})
    void checkerGoodInput(String input) {
        assertDoesNotThrow(() -> {
            game.checker(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"()&^(#", "peko", "e-die-e-die-e-die", "TSJ", ""})
    void checkerBadInput(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.checker(input);
        });
        assertEquals("java.lang.IllegalArgumentException: Bad choice :( ", exception.toString());
    }

    @ParameterizedTest
    @MethodSource("player1WinListProvider")
    void judgePlayer1Win(String player1, String player2) {

        assertEquals("Player1 win!", game.judge(player1, player2));
    }

    @ParameterizedTest
    @MethodSource("player2WinListProvider")
    void judgePlayer2Win(String player1, String player2) {

        assertEquals("Player2 win!", game.judge(player1, player2));
    }

    @ParameterizedTest
    @MethodSource("DrawListProvider")
    void judgePlayerDraw(String player1, String player2) {

        assertEquals("Draw!", game.judge(player1, player2));
    }
}