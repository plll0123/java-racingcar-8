package racingcar.application.reader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

}