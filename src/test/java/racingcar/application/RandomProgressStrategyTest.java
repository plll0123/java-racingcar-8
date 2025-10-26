package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomProgressStrategyTest {

    @Test
    void 클래스_설정값_검증() {
        assertThat(RandomProgressStrategy.MIN_NUMBER).isSameAs(0);
        assertThat(RandomProgressStrategy.MAX_NUMBER).isSameAs(9);
        assertThat(RandomProgressStrategy.THRESHOLD).isSameAs(4);
    }

}