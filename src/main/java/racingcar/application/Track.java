package racingcar.application;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private static final String DISPLAY_FORMAT = "%s : %s";

    private final ProgressStrategy progressStrategy;
    private final List<Car> cars;
    private final int roundCount;

    private final StringBuilder displayBoard = new StringBuilder();
    private final String progressBarFormat;

    private final List<String> winners = new ArrayList<>();

    public Track(ProgressStrategy progressStrategy, RaceInformation raceInformation) {
        this(progressStrategy, raceInformation.cars(), raceInformation.roundCount(), "-");
    }

    public Track(ProgressStrategy progressStrategy, List<Car> cars, int roundCount, String progressBarFormat) {
        this.progressStrategy = progressStrategy;
        this.cars = cars;
        this.roundCount = roundCount;
        this.progressBarFormat = progressBarFormat;
    }

    public void raceStart() {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(this::takeTurn);
            displayBoard.append("\n");
        }
    }

    public void endRace() {
        int asInt = cars.stream()
                .mapToInt(Car::getMileage)
                .max()
                .orElse(0);
        cars.stream()
                .filter(it -> it.getMileage() == asInt)
                .forEach(it -> winners.add(it.getName()));
    }

    public String getRecord() {
        return displayBoard.append("최종 우승자 : ")
                .append(String.join(", ", winners))
                .toString();
    }

    protected String getDisplayFormat(Car car) {
        String progressBar = progressBarFormat.repeat(Math.max(0, car.getMileage()));
        return DISPLAY_FORMAT.formatted(car.getName(), progressBar);
    }

    private void takeTurn(Car car) {
        car.advance(progressStrategy);
        displayBoard.append(getDisplayFormat(car)).append("\n");
    }
}
