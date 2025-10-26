package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomProgressStrategy implements ProgressStrategy {

    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;
    static final int THRESHOLD = 4;

    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= THRESHOLD;
    }

}
