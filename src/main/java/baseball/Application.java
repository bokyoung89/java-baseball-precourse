package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.BaseballNumberGenerator;
import baseball.view.PlayerBallNumberInput;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(
                new PlayerBallNumberInput(),
                new BaseballNumberGenerator()
        );
        baseballGameController.playGame();
    }
}
