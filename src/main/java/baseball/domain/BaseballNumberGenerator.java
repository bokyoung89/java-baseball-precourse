package baseball.domain;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberGenerator {

    List<Integer> generate(){
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < NumberConstant.SIZE_NUMBER){
            ballNumbers.add(Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER));
        }
        return new ArrayList<>(ballNumbers);
    }
}
