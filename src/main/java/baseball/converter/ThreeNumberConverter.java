package baseball.converter;

import baseball.exception.DuplicateNumberException;
import baseball.exception.GameEachInputNumberOutOfRangeException;
import baseball.exception.GameInputNumberOutOfRangeException;
import baseball.exception.IllegalNumberInputException;
import baseball.exception.InputNumberFormatException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeNumberConverter {

    private static final int NUMBER_RANGE_SIZE = 3;
    private String inputString;
    
    public List<Integer> getThreeNumbers(String inputString) throws IllegalNumberInputException {
        this.inputString = inputString;
        List<Integer> integerList = getIntegerListByInputString();
        validateIntegerList(integerList);
        return integerList;
    }
    
    private List<Integer> getIntegerListByInputString() {
        List<String> splitInputList = toSplitList();
        return getIntegerList(splitInputList);
    }

    private List<String> toSplitList() {
        return List.of(inputString.split(""));
    }

    private List<Integer> getIntegerList(List<String> splitInputList) {
        List<Integer> integerList;
        try {
            integerList = splitInputList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputNumberFormatException(inputString);
        }
        return integerList;
    }

    private void validateIntegerList(List<Integer> integerList) {
        Set<Integer> numSet = new HashSet<>(integerList);
        validateEachNumberRange(numSet);
        validateRange(integerList);
        validateDuplicateNumber(numSet, integerList);
    }

    private void validateEachNumberRange(Set<Integer> numSet) {
        if (numSet.contains(0)) {
            throw new GameEachInputNumberOutOfRangeException(inputString);
        }
    }

    private void validateRange(List<Integer> integerList) {
        if (integerList.size() != NUMBER_RANGE_SIZE) {
            throw new GameInputNumberOutOfRangeException(inputString);
        }
    }

    private void validateDuplicateNumber(Set<Integer> numSet, List<Integer> integerList) {
        if (numSet.size() != integerList.size()) {
            throw new DuplicateNumberException(inputString);
        }
    }
}
