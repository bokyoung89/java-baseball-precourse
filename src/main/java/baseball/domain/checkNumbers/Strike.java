package baseball.domain.checkNumbers;

import baseball.constant.NumberConstant;
import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;

public class Strike {

    private int count;

    public Strike() {
        this.count = 0;
    }

    public void judge(BallNumbers computerNumbers, BallNumbers playerNumbers) {
        for (int i = 0; i < NumberConstant.SIZE_NUMBER; i++) {
            BallNumber computerBallNumber = computerNumbers.getBallNumberByIdx(i);
            BallNumber playerBallNumber = playerNumbers.getBallNumberByIdx(i);
            strikeCheck(computerBallNumber.equals(playerBallNumber));
        }
    }

    private void strikeCheck(boolean isStrike) {
        if(isStrike){
            this.count ++;
        }
    }

    public int getCount() {
        return this.count;
    }

    public void clear() {
        this.count = 0;
    }

    public boolean has() {
        return this.count > 0;
    }
}
