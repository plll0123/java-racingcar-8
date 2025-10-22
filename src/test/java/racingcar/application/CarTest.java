package racingcar.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  ", "123456"})
    void invalid_car_name(String source) {
        assertThatThrownBy(() -> new Car(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_TOO_LONG);
    }

    @Test
    void 자동차_전진시_1을_더한다() {
        Car car = new Car("car!", 0);
        car.advance(() -> true);
        assertThat(car.getMileage()).isOne();
    }

}