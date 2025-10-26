package racingcar;

import racingcar.application.RaceInformation;
import racingcar.application.RandomProgressStrategy;
import racingcar.application.Track;
import racingcar.application.reader.Reader;
import racingcar.application.writer.Writer;

public class Application {

    public static void main(String[] args) {
        RaceInformation raceInformation = new Reader().read();
        Track track = new Track(new RandomProgressStrategy(), raceInformation);
        track.raceStart();
        track.endRace();
        String result = track.getRecord();
        new Writer().write(result);
    }

}
