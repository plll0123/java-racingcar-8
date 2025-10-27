package racingcar.application;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private final ProgressStrategy progressStrategy;

    private final List<Car> cars;

    private final int roundCount;

    private final DisplayBoard displayBoard;

    private final List<String> winners = new ArrayList<>();

    public Track(ProgressStrategy progressStrategy, RaceInformation raceInformation, DisplayBoard displayBoard) {
        this.progressStrategy = progressStrategy;
        this.cars = raceInformation.cars();
        this.roundCount = raceInformation.roundCount();
        this.displayBoard = displayBoard;
    }

    public void raceStart() {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(e -> e.advance(progressStrategy));
            displayBoard.recordStatus(cars);
        }
    }

    public void endRace() {
        int maxMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .max()
                .orElse(0);
        cars.stream()
                .filter(it -> it.getMileage() == maxMileage)
                .forEach(it -> winners.add(it.getName()));
        displayBoard.recordWinner(winners);
        displayBoard.print();
    }

}
