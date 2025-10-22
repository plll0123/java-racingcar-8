package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

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

}