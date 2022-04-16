package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest{

    @Test
    @DisplayName("split 분리 테스트")
    public void 학습테스트_01(){
        //given
        String number = "1,2";

        //when
        String[] inputSplit = number.split(",");

        //then
        assertThat(inputSplit).containsExactly("1","2");
    }

    @Test
    @DisplayName("split 배열 반환 테스트")
    public void 학습테스트_02(){
        //given
        String number = "1";

        //when
        String[] inputSplit = number.split(",");

        //then
        assertThat(inputSplit).containsExactly("1");
    }

    @Test
    @DisplayName("Substring()으로 소괄호 제거 테스트")
    public void 학습테스트_03(){
        //given
        String number = "(1,2)";

        //when
        String inputSubstring = number.substring(1,4);

        //then
        assertThat(inputSubstring).isEqualTo("1,2");

    }

    @Test
    @DisplayName("charAt()으로 특정 위치의 문자 반환 테스트")
    public void 학습테스트_04(){
        //given
        String str = "abc";

        //when
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        char ch3 = str.charAt(2);

        //then
        assertThat(ch1).isEqualTo('a');
        assertThat(ch2).isEqualTo('b');
        assertThat(ch3).isEqualTo('c');

    }

    @Test
    @DisplayName("특정 위치의 문자 반환할 때 위치 값 벗어나면 예외 발생 테스트")
    public void 학습테스트_05(){
        //given
        String str = "abc";

        //when, then
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + str.length());
    }
}