package racingcar.application;

import java.util.List;

public class RaceFixture {

    public static RaceInformation create(Car car) {
        return new RaceInformation(1, List.of(new Car(car.getName(), car.getMileage())));
    }

}
