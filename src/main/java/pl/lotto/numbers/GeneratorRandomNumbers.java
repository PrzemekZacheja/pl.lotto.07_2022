package pl.lotto.numbers;

import pl.lotto.interfaces.Numbers;
import pl.lotto.validator.ReplayChecker;
import pl.lotto.validator.ValidatorOfRange;

import java.io.IOException;
import java.util.Random;

public class GeneratorRandomNumbers implements Numbers {

    private static final int ROUND_OF_LOTTERY = 6;
    private final int[] numbersFromPlayer = new int[ROUND_OF_LOTTERY];
    ValidatorOfRange validator;
    ReplayChecker checker;
    Random random;

    public GeneratorRandomNumbers() {
        this.random = new Random();
        this.validator = new ValidatorOfRange(1,99);
        this.checker = new ReplayChecker();
    }

    @Override
    public int[] getNumbers() throws IOException {
        for (int i = 0; i < numbersFromPlayer.length; i++) {
            numbersFromPlayer[i] = getCorrectNumber();
        }
        return numbersFromPlayer;
    }

    private int getCorrectNumber() throws IOException {
        int oneNumberFromBuffer = getRandomNumber();
        oneNumberFromBuffer = getNumberInRange(oneNumberFromBuffer);
        oneNumberFromBuffer = getUniqueNumber(oneNumberFromBuffer);
        return oneNumberFromBuffer;
    }

    private int getNumberInRange(int oneNumberFromBuffer) throws IOException {
        while (!validator.validate(oneNumberFromBuffer)) {
            oneNumberFromBuffer = getRandomNumber();
            getUniqueNumber(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }

    private int getUniqueNumber(int oneNumberFromBuffer) throws IOException {
        while (checker.check(oneNumberFromBuffer, numbersFromPlayer)) {
            oneNumberFromBuffer = getRandomNumber();
            getNumberInRange(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }

    private int getRandomNumber(){
        return random.nextInt(99);
    }
}
