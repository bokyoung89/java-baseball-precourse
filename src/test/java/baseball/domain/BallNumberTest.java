package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.view.PlayerBallNumberInput.INVALID_NUMBER;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallNumberTest {

    @DisplayName("BallNumber 생성 테스트 : 유효한 범위")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void generateballNumber(int number){
        // given
        // when
        BallNumber ballNumber = BallNumber.of(number);

        // then
        assertEquals(number, ballNumber.getNumber());
    }

    @DisplayName("BallNumber 생성 테스트 : 유효하지 않은 값")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    public void IllegalArgumentExceptionGenerateballNumber(int number){
        // given
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumber.of(number))
                .withMessageMatching(INVALID_NUMBER);
    }
}
