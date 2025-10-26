package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AtomicBooleanAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.writer.Writer;

class TrackTest {

//    @ParameterizedTest
//    @CsvSource(textBlock = """
//            hun, 0, 'hun : '
//            poby, 1, poby : -
//            java, 2, java : --
//            """)
//    void 라운드별_출력_형식_검증(String carName, int mileage, String expectDisplay) {
//        var car = new Car(carName, mileage);
//        var raceInformation = new RaceInformation(1, List.of(car));
//        var called = new AtomicBoolean();
//        DisplayBoard displayBoard = new DisplayBoard("-", null) {
//
//        }
//        Track track = new Track(new RandomProgressStrategy(), raceInformation, displayBoard);
//        track.raceStart();
//
//        assertThat(car.getMileage()).isEqualTo(mileage);
//        assertThat(displayBoard.getValue()).isEqualTo(expectDisplay);
//    }

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