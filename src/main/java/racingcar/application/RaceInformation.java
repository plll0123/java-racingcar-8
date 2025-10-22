package racingcar.application;

import java.util.List;

public record RaceInformation(
        int roundCount,
        List<Car> cars
) {
}
