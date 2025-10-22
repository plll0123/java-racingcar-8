package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.application.ProgressStrategy;

class RandomProgressProgressStrategy implements ProgressStrategy {

    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
