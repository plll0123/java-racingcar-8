package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TrackTest {

    @Test
    void 레이스_결과_검증() {
        var car = new Car("plll1");
        var raceInformation = new RaceInformation(3, List.of(car));
        DisplayBoard displayBoard = new DisplayBoard("-", null);
        Track track = new Track(() -> true, raceInformation, displayBoard);
        track.raceStart();

        assertThat(car.getMileage()).isEqualTo(3);
        assertThat(displayBoard.getValue()).isEqualTo("""
                plll1 : -
                
                plll1 : --
                
                plll1 : ---
                
                """);
    }

    @Test
    void 레이스_종료시_우승자를_기록한다() {
        Car car1 = new Car("one", 1);
        Car car2 = new Car("two", 2);
        DisplayBoard displayBoard = new DisplayBoard("-", result -> {
            //writer do nothing
        });
        Track track = new Track(() -> true, new RaceInformation(0, List.of(car1, car2)), displayBoard);
        track.endRace();
        assertThat(displayBoard.getValue()).isEqualTo("최종 우승자 : two");
    }

}