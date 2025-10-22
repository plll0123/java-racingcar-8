package racingcar.application.reader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.application.Car;
import racingcar.application.RaceInformation;

class ReaderTest {

    private String source;
    private int roundCount;

    @AfterEach
    void tearDown() {
        source = null;
        roundCount = 0;
    }

    private final Reader reader = new Reader() {
        @Override
        public Config doRead() {
            return new Config(source, roundCount);
        }
    };

    @Test
    void default_delimiter() {
        assertThat(Reader.DEFAULT_DELIMITER).isEqualTo(",");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름_목록은_빈_값이나_null일_수_없다(String source) {
        this.source = source;

        assertThatThrownBy(reader::read).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_객체_목록을_반환한다() {
        this.source = "pobbi,wtc,plll";
        this.roundCount = 7;

        RaceInformation raceInformation = reader.read();
        assertThat(raceInformation.cars()).hasSize(3)
                .contains(
                        new Car("pobbi"),
                        new Car("wtc"),
                        new Car("plll")
                );
        assertThat(raceInformation.roundCount()).isEqualTo(roundCount);
    }

}