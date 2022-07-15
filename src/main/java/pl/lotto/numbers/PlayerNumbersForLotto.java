package pl.lotto.numbers;

import pl.lotto.messengers.Messenger;
import pl.lotto.interfaces.Numbers;
import pl.lotto.validator.ReplayChecker;
import pl.lotto.validator.ValidatorOfRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerNumbersForLotto implements Numbers {

    private static final int ROUND_OF_LOTTERY = 6;
    private final int[] numbersFromPlayer = new int[ROUND_OF_LOTTERY];
    ValidatorOfRange validator;
    BufferedReader reader;
    ReplayChecker checker;


    public PlayerNumbersForLotto() {
        this.validator = new ValidatorOfRange(1, 99);
        reader = new BufferedReader(new InputStreamReader(System.in));
        checker = new ReplayChecker();
    }

    @Override
    public int[] getNumbers() throws IOException {
        for (int i = 0; i < numbersFromPlayer.length; i++) {
            System.out.println(Messenger.ONE_NUMBER + (i+1));
            numbersFromPlayer[i] = getCorrectNumber();
        }
        reader.close();
        return numbersFromPlayer;
    }

    private int getCorrectNumber() throws IOException {
        int oneNumberFromBuffer = reader.read();
        oneNumberFromBuffer = getNumberInRange(oneNumberFromBuffer);
        oneNumberFromBuffer = getUniqueNumber(oneNumberFromBuffer);
        return oneNumberFromBuffer;
    }

    private int getNumberInRange(int oneNumberFromBuffer) throws IOException {
        while (!validator.validate(oneNumberFromBuffer)) {
            System.out.println(Messenger.WRONG_NUMBER);
            oneNumberFromBuffer = reader.read();
            getUniqueNumber(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }

    private int getUniqueNumber(int oneNumberFromBuffer) throws IOException {
        while (checker.check(oneNumberFromBuffer, numbersFromPlayer)){
            System.out.println(Messenger.NUMBER_ALREADY_EXIST);
            oneNumberFromBuffer = reader.read();
            getNumberInRange(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }
}
