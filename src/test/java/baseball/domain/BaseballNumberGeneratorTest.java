package baseball.domain;

import baseball.constant.NumberConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberGeneratorTest {

    @Test
    @DisplayName("생성되는 숫자는 3자리이다")
    public void generateTest_01(){
        //given
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        //when, then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성되는 3가지 숫자는 중복되지 않는다")
    public void generateTest_02(){
        //given
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        //when
        Set<Integer> numbers2 = new HashSet<>(numbers);

        //then
        assertThat(numbers.size()).isEqualTo(numbers2.size());

    }
}
