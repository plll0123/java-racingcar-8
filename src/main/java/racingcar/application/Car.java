package racingcar.application;

import java.util.Objects;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int mileage;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String carName, int mileage) {
        validateCarName(carName);
        this.name = carName;
        this.mileage = mileage;
    }

    public void advance(ProgressStrategy progressStrategy) {
        if (progressStrategy.movable()) {
            this.mileage += 1;
        }
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_TOO_LONG);
        }
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "carName='" + name + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return mileage == car.mileage && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mileage);
    }
}