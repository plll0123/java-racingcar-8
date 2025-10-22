package racingcar.application.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.application.Car;
import racingcar.application.ExceptionMessage;

public class Reader {

    static final String DEFAULT_DELIMITER = ",";

    public Object read() {
        Config config = doRead();
        String carName = config.carName;
        validateInputSource(carName);
        List<Car> cars = parseAndConvert(carName);
        return new Object[] {cars};
    }

    Config doRead() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundCount = Integer.parseInt(Console.readLine());
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
