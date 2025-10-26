package racingcar.application.writer;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String result) {
        System.out.println(result);
    }

}
