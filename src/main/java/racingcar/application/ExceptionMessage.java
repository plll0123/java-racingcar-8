package racingcar.application;

public class ExceptionMessage {

    private ExceptionMessage() {
        throw new UnsupportedOperationException("인스턴스 생성이 금지된 유틸 클래스입니다.");
    }

    public static final String CAR_NAME_TOO_LONG = "자동차 이름이 너무 깁니다.";
    public static final String INVALID_RACER_NAME = "레이서 이름을 잘못 입력하였습니다.";

}
