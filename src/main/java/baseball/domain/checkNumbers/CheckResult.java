package baseball.domain.checkNumbers;

import baseball.domain.BallNumbers;
import baseball.view.HintPrinter;

public class CheckResult {

    public static final String GAME_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private Strike strike;
    private Ball ball;
    private HintPrinter hintPrinter;

    private JudgeStatus judgeStatus;
    private CheckResult() {
        this.strike = new Strike();
        this.ball = new Ball();
        this.hintPrinter = new HintPrinter(strike, ball);
        this.judgeStatus = judgeStatus.IN_PLAY;
    }

    public static CheckResult create() {
        return new CheckResult();
    }

    public void judge(BallNumbers computerNumbers, BallNumbers playerNumbers) {
        strike.judge(computerNumbers, playerNumbers);
        ball.judge(computerNumbers, playerNumbers);

        System.out.println(this.judgeResultMessage());
        if(this.isGameComplete()){
            System.out.println(GAME_COMPLETE);
        }
        this.countClear();
    }

    private boolean isGameComplete() {
        boolean isStrike3 = this.strike.getCount() == 3 && this.ball.getCount() == 0;
        if(isStrike3){
            this.judgeStatus = JudgeStatus.GAME_OVER;
        }
        return isStrike3;
    }

    public String judgeResultMessage() {
        return this.hintPrinter.printResult();
    }

    public boolean isPlay() {
        return this.judgeStatus == JudgeStatus.IN_PLAY;
    }

    public void countClear() {
        this.strike.clear();
        this.ball.clear();
    }
}
