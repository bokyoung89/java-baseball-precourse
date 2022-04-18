package baseball.domain;

import baseball.constant.NumberConstant;

import java.util.ArrayList;
import java.util.List;

public class BallNumbers {

    public static final String INVALID_NUMBER_SIZE = "숫자 길이가 유효하지 않습니다.";
    public static final String NUMBER_IS_NOT_EMPTY = "빈 숫자는 유효하지 않습니다.";
    private List<BallNumber> ballNumbers;

    private BallNumbers(List<BallNumber> ballNumbers){
        validateNumbers(ballNumbers);
        this.ballNumbers = ballNumbers;
    }

    public static BallNumbers of(List<Integer> numbers) {
        List<BallNumber> results = new ArrayList<>();
        for (Integer number : numbers) {
            results.add(BallNumber.of(number));
        }
        return new BallNumbers(results);
    }

    public int size() {
        return this.ballNumbers.size();
    }

    private void validateNumbers(List<BallNumber> ballNumbers) {
        emptyValidate(ballNumbers);
        availableSizeValidate(ballNumbers);
    }

    private void availableSizeValidate(List<BallNumber> ballNumbers) {
        if(ballNumbers.size() != NumberConstant.SIZE_NUMBER){
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private void emptyValidate(List<BallNumber> ballNumbers) {
        if(ballNumbers.isEmpty()){
            throw new IllegalArgumentException(NUMBER_IS_NOT_EMPTY);
        }
    }


    public BallNumber getBallNumberByIdx(int idx) {
        return this.ballNumbers.get(idx);
    }

    public boolean contains(BallNumber ballNumber) {
        return this.ballNumbers.contains(ballNumber);
    }
}
