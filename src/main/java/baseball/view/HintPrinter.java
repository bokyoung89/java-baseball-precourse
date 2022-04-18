package baseball.view;

import baseball.domain.checkNumbers.Ball;
import baseball.domain.checkNumbers.Strike;

public class HintPrinter {

    public static final String THREE_STRIKE = "3스트라이크";
    public static final String STRIKE_WITH_BALL = "%s볼 %s스트라이크";
    public static final String ONLY_BALL = "%s볼";
    public static final String ONLY_STRIKE = "%s스트라이크";
    public static final String NOTHING = "낫싱";

    private final Strike strike;
    private final Ball ball;

    public HintPrinter(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String printResult() {
        if (strike.getCount() == 3 && ball.getCount() == 0) {
            return String.format(THREE_STRIKE);
        }

        if (strike.has() && ball.has()) {
            return String.format(STRIKE_WITH_BALL, ball.getCount(), strike.getCount());
        }

        if (!strike.has() && ball.has()) {
            return String.format(ONLY_BALL, ball.getCount());
        }

        if (strike.has() && !ball.has()) {
            return String.format(ONLY_STRIKE, strike.getCount());
        }

        return NOTHING;
    }

}
