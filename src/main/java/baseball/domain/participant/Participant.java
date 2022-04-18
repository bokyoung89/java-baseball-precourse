package baseball.domain.participant;

import baseball.domain.BallNumbers;

public class Participant {

    private final BallNumbers baseballNumbers;

    public Participant(BallNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public BallNumbers getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
