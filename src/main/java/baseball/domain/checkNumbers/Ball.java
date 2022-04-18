package baseball.domain.checkNumbers;

import baseball.constant.NumberConstant;
import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;

public class Ball {

    private int count;

    public Ball() {
        this.count = 0;
    }

    public void judge(BallNumbers computerBallNumbers, BallNumbers playerBallNumbers) {
        for (int i = 0; i < NumberConstant.SIZE_NUMBER; i++) {
            BallNumber computerBallNumber = computerBallNumbers.getBallNumberByIdx(i);
            BallNumber playerBallNumber = playerBallNumbers.getBallNumberByIdx(i);

            ballCheck(ballCondition(computerBallNumbers, computerBallNumber, playerBallNumber));
        }
    }

    private void ballCheck(boolean isBall) {
        if (isBall) {
            this.count++;
        }
    }

    private boolean ballCondition(BallNumbers computerBallNumbers, BallNumber computerBallNumber,
                                  BallNumber playerBallNumber) {

        return computerBallNumbers.contains(playerBallNumber) &&
                !computerBallNumber.equals(playerBallNumber);
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
