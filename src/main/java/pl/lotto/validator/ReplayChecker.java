package pl.lotto.validator;

public class ReplayChecker {

    public boolean check(int oneNumberFromBuffer, int[] numbersFromPlayer) {
        boolean returnedFlag = false;
        for (int number : numbersFromPlayer) {
            if (number == oneNumberFromBuffer) {
                returnedFlag = true;
                break;
            }
        }
        return returnedFlag;
    }
}
