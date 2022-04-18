package baseball.domain;

import baseball.constant.NumberConstant;

import java.util.Objects;

import static baseball.view.PlayerBallNumberInput.INVALID_NUMBER;

public class BallNumber {
    private final int number;

    private BallNumber(int number) {
        this.number = number;
    }

    public static BallNumber of(Integer number) {
        validateNumber(number);
        return new BallNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    private static void validateNumber(Integer number) {
        if (number < NumberConstant.MIN_NUMBER || number > NumberConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


}
