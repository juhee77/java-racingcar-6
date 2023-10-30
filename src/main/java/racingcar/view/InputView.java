package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Constants.*;

public class InputView {
    private final Validator validator = new Validator();

    public List<String> getCarsName() {
        System.out.println(INPUT_CARS);
        return extractAndValidateCarNames(Console.readLine());
    }

    public int getRepeatCount() {
        System.out.println(INPUT_REPEAT_COUNT);
        return extractAndValidateRepeatCount(Console.readLine());
    }

    public List<String> extractAndValidateCarNames(String input) {
        validator.validateInput(input);

        String[] carNames = input.split(INPUT_SPLIT_STRING);
        List<String> validCarNames = new ArrayList<>();

        for (String carName : carNames) {
            String trimCarName = carName.trim();
            validator.validateCarName(trimCarName);
            validCarNames.add(trimCarName);
        }

        return validCarNames;
    }

    public int extractAndValidateRepeatCount(String input) {
        try {
            int repeatCnt = Integer.parseInt(input);
            if (repeatCnt <= MIN_REPEAT_CNT || MAX_REPEAT_CNT < repeatCnt)
                throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
            return repeatCnt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
        }
    }


}
