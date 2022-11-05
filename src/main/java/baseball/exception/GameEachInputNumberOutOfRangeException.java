package baseball.exception;

public class GameEachInputNumberOutOfRangeException extends IllegalNumberInputException {

    private static final String NUMBER_OUT_OF_RANGE_ERROR = "1~9 사이의 숫자를 입력해주세요. 입력 문자: %s";

    public GameEachInputNumberOutOfRangeException(String str) {
        super(String.format(NUMBER_OUT_OF_RANGE_ERROR, str));
    }
}
