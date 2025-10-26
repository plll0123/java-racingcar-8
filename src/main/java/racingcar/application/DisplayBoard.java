package racingcar.application;

import java.util.List;
import racingcar.application.writer.Writer;

public class DisplayBoard {

    private static final String DISPLAY_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    private final StringBuilder value = new StringBuilder();

    private final String progressBarFormat;

    private final Writer writer;

    public DisplayBoard(String progressBarFormat, Writer writer) {
        this.progressBarFormat = progressBarFormat;
        this.writer = writer;
    }

    public void recordStatus(List<Car> cars) {
        cars.forEach(e -> {
            String progressBar = progressBarFormat.repeat(Math.max(0, e.getMileage()));
            String displayFormat = DISPLAY_FORMAT.formatted(e.getName(), progressBar);
            value.append(displayFormat).append("\n");
        });
        value.append("\n");
    }

    public void recordWinner(List<String> winners) {
        String winnerMessage = WINNER_MESSAGE_FORMAT.formatted(String.join(", ", winners));
        value.append(winnerMessage);
    }

    public void print() {
        writer.write(value.toString());
    }

    public String getValue() {
        return value.toString();
    }

}
