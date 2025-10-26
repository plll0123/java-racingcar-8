package racingcar;

import racingcar.application.DisplayBoard;
import racingcar.application.RaceInformation;
import racingcar.application.RandomProgressStrategy;
import racingcar.application.Track;
import racingcar.application.reader.Reader;
import racingcar.application.writer.ConsoleWriter;
import racingcar.application.writer.Writer;

public class Application {

    public static void main(String[] args) {
        Reader reader = new Reader();
        RaceInformation raceInformation = reader.read();
        Writer writer = new ConsoleWriter();
        DisplayBoard displayBoard = new DisplayBoard("-", writer);
        Track track = new Track(new RandomProgressStrategy(), raceInformation, displayBoard);
        track.raceStart();
        track.endRace();
    }

}
