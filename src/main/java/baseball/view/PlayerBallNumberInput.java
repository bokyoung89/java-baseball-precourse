package baseball.view;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class PlayerBallNumberInput {

    public static final String INPUT_NUMBER_MASSAGE = "숫자를 입력해주세요 : ";
    public static final String INVALID_NUMBER = "숫자는 1~9 사이만 가능합니다.";
    public static final String INVALID_INPUT_BASEBALL_NUMBER = "1 ~ 9 사이 숫자로 구성된 서로다른 3개의 숫자만 입력 가능합니다.";

    public List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBER_MASSAGE);
        String inputNum = Console.readLine();

        if (!AvailableNumbers(inputNum)) {
            throw new IllegalArgumentException(INVALID_INPUT_BASEBALL_NUMBER);
        }

        return ListNumbers(inputNum);
    }

    private List<Integer> ListNumbers(String inputNum) {
        List<String> strNumbers = Arrays.asList(inputNum.split(""));
        List<Integer> numbers = new ArrayList<>();
        for (String strNumber : strNumbers) {
            numbers.add(Integer.parseInt(strNumber));
        }
        return numbers;
    }

    private boolean AvailableNumbers(String inputNum) {
        if (!AvailableSize(inputNum)) {
            return false;
        }

        if (!UniInputNumbers(inputNum)) {
            return false;
        }

        return AvailableNumberRange(inputNum);
    }

    private boolean AvailableNumberRange(String inputNumber) {
        return inputNumber.matches(NumberConstant.INPUT_NUMBER_REG_EXP);
    }

    private boolean UniInputNumbers(String inputNum) {
        List<String> splitInputNumbers = Arrays.asList(inputNum.split(""));
        Set<String> inputNumbersSet = new HashSet<>(splitInputNumbers);

        return inputNumbersSet.size() == NumberConstant.SIZE_NUMBER;
    }

    private boolean AvailableSize(String inputNum) {
        return inputNum != null && inputNum.length() == NumberConstant.SIZE_NUMBER;
    }
}
