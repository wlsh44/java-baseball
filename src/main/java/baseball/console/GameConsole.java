package baseball.console;

import baseball.console.input.converter.RestartOrExitCodeConverter;
import baseball.console.input.converter.ThreeNumberConverter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameConsole {

    private final ThreeNumberConverter threeNumberConverter;
    private final RestartOrExitCodeConverter codeConverter;

    public GameConsole() {
        this.threeNumberConverter = new ThreeNumberConverter();
        this.codeConverter = new RestartOrExitCodeConverter();
    }

    public List<Integer> inputThreeNumbers() {
        String inputString = input();
        return threeNumberConverter.getThreeNumbers(inputString);
    }

    public Integer inputCode() {
        String inputString = input();
        return codeConverter.getRestartOrExitCode(inputString);
    }

    private String input() {
        return Console.readLine();
    }
}
