package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayBoardTest {

    private DisplayBoard displayBoard;

    @BeforeEach
    void setUp() {
        displayBoard = new DisplayBoard("~", null);
    }

    @Test
    void 각_라운드는_자돋차의_기록을_새로운_줄에_작성한다() {
        displayBoard.recordStatus(List.of(
                new Car("pobi", 0),
                new Car("jun", 1)
        ));
        assertThat(displayBoard.getValue()).isEqualTo("""
                pobi :\s
                jun : ~
                
                """);
    }

    @Test
    void 우승자를_기록한다() {
        List<String> winners = List.of("123", "pobi");
        displayBoard.recordWinner(winners);
        assertThat(displayBoard.getValue()).isEqualTo("최종 우승자 : 123, pobi");
    }

}