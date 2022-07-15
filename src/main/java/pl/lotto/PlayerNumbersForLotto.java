package pl.lotto;

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
        int oneNumberFromBuffer = Integer.parseInt(reader.readLine());
        oneNumberFromBuffer = getNumberInRange(oneNumberFromBuffer);
        oneNumberFromBuffer = getUniqueNumber(oneNumberFromBuffer);
        return oneNumberFromBuffer;
    }

    private int getNumberInRange(int oneNumberFromBuffer) throws IOException {
        while (!validator.validate(oneNumberFromBuffer)) {
            System.out.println(Messenger.WRONG_NUMBER);
            oneNumberFromBuffer = Integer.parseInt(reader.readLine());
            getUniqueNumber(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }

    private int getUniqueNumber(int oneNumberFromBuffer) throws IOException {
        while (checker.check(oneNumberFromBuffer, numbersFromPlayer)){
            System.out.println(Messenger.NUMBER_ALREADY_EXIST);
            oneNumberFromBuffer = Integer.parseInt(reader.readLine());
            getNumberInRange(oneNumberFromBuffer);
        }
        return oneNumberFromBuffer;
    }
}
