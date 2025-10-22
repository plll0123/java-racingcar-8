package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TrackTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            poby, 1, poby : -
            hun, 0, 'hun : '
            java, 2, java : --
            """)
    void 전광판_출력_형식_테스트(String carName, int  mileage, String expectDisplay) {
        Car car = new Car(carName, mileage);
        RaceInformation raceInformation = RaceFixture.create(car);
        Track track = new Track(null, raceInformation);
        assertThat(track.getDisplayFormat(car)).isEqualTo(expectDisplay);
    }

    @Test
    void 레이스_종료시_우승자를_기록한다() {
        Car car1 = new Car("one", 1);
        Car car2 = new Car("two", 2);
        RaceInformation raceInformation = new RaceInformation(3, List.of(car1, car2));
        Track track = new Track(null, raceInformation);
        track.endRace();
        assertThat(track.getRecord()).isEqualTo("최종 우승자 : two");
    }

}