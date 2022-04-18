package baseball.controller;

import baseball.domain.BallNumbers;
import baseball.domain.BaseballNumberGenerator;
import baseball.domain.participant.Computer;
import baseball.domain.checkNumbers.CheckResult;
import baseball.view.PlayerBallNumberInput;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameController {

    public static final String IS_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final PlayerBallNumberInput playerBallNumberInput;
    private final BaseballNumberGenerator baseballNumberGenerator;

    public BaseballGameController(PlayerBallNumberInput playerBallNumberInput,
                                  BaseballNumberGenerator baseballNumberGenerator) {
        this.playerBallNumberInput = playerBallNumberInput;
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void playGame() {
        CheckResult referee = CheckResult.create();
        Computer computer = Computer.generateBy(baseballNumberGenerator);

        while (referee.isPlay()) {
            List<Integer> playerInputNumbers = this.playerBallNumberInput.inputNumbers();
            BallNumbers playerBaseballNumbers = BallNumbers.of(playerInputNumbers);

            referee.countClear();
            referee.judge(computer.getBaseballNumbers(), playerBaseballNumbers);
        }
        restartOrExist();
    }

    private void restartOrExist() {
        System.out.println(IS_CONTINUE);
        String restartOrExist = Console.readLine();
        if (restartOrExist.equals("1")) {
            playGame();
        }
    }
}
