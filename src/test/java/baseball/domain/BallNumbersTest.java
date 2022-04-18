package baseball.domain;

import baseball.constant.NumberConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.BallNumbers.INVALID_NUMBER_SIZE;
import static baseball.domain.BallNumbers.NUMBER_IS_NOT_EMPTY;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallNumbersTest {
    @Test
    @DisplayName("BallNumbers 생성 테스트 : 정상")
    public void generateBallNumbers(){
        //given, when
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();
        BallNumbers ballNumbers = BallNumbers.of(numbers);

        // then
        assertEquals(NumberConstant.SIZE_NUMBER, ballNumbers.size());
    }

    @Test
    @DisplayName("BallNumbers 생성 테스트 : 숫자 길이 초과")
    public void exceptionGenerateBallNumbers_01(){
        //given, when
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumbers.of(numbers))
                .withMessageMatching(INVALID_NUMBER_SIZE);
    }

    @Test
    @DisplayName("BallNumbers 생성 테스트 : 빈 숫자 값")
    void exceptionGenerateBallNumbers_02() {
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumbers.of(new ArrayList<>()))
                .withMessageMatching(NUMBER_IS_NOT_EMPTY);
    }
}
