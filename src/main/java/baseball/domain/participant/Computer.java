package baseball.domain.participant;

import baseball.domain.BallNumbers;
import baseball.domain.BaseballNumberGenerator;

import java.util.List;

public class Computer extends Participant{

    private Computer(BallNumbers ballNumbers) {
        super(ballNumbers);
    }

    public static Computer generateBy(BaseballNumberGenerator baseballNumberGenerator) {
        List<Integer> generateNumbers = baseballNumberGenerator.generate();
        return new Computer(BallNumbers.of(generateNumbers));
    }
}
