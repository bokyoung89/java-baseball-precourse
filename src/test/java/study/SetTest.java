package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드로 Set의 크기를 확인하는 테스트")
    void 학습테스트_01(){
        //given, when
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메소드로 1,2,3 값이 존재하는 확인하는 테스트(동일 테스트 반복 : ParameterizedTest, value=ValueSource)")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 학습테스트_02(int num){
        //given, when
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("contains() 메소드로 1,2,3 값이 존재하는 확인하는 테스트(동일 테스트 반복 : ParameterizedTest, value=CsvSource)")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void 학습테스트_03(int num, boolean result){
        //given, when
        assertThat(numbers.contains(num)).isEqualTo(result);
    }
}