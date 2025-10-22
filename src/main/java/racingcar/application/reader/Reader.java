package racingcar.application.reader;

import java.util.Arrays;
import java.util.List;
import racingcar.application.Car;
import racingcar.application.ExceptionMessage;
import racingcar.application.RaceInformation;

public class Reader {

    static final String DEFAULT_DELIMITER = ",";

    public RaceInformation read() {
        Config config = doRead();
        String carName = config.carName;
        validateInputSource(carName);
        List<Car> cars = parseAndConvert(carName);
        return new RaceInformation(config.roundCount, cars);
    }

    Config doRead() {
        String carNames = Input.readCarNames();
        int roundCount = Input.readRoundCount();
        return new Config(carNames, roundCount);
    }

    private void validateInputSource(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACER_NAME);
        }
    }

    private List<Car> parseAndConvert(String source) {
        return Arrays.stream(source.split(DEFAULT_DELIMITER))
                .map(Car::new)
                .toList();
    }

    record Config(
            String carName,
            int roundCount
    ) {
    }
}
