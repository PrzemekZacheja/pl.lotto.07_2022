package pl.lotto;

import java.io.IOException;
import java.util.Arrays;

public class Lotto implements Game {

    Numbers numbersFromPlayer = new PlayerNumbersForLotto();
    Numbers random = new GeneratorRandomNumbers();

    @Override
    public void play() throws IOException {
        showStartingInstructions();
        int[] playerNumbers = numbersFromPlayer.getNumbers();
        int[] randomNumbers = random.getNumbers();
        if (isArraysEquals(playerNumbers, randomNumbers)) {
            System.out.println(Messenger.WINNER);
        } else {
            System.out.println(Messenger.LOOSE);
        }
    }

    private boolean isArraysEquals(int[] playerNumbers, int[] randomNumbers) {
        Arrays.sort(playerNumbers);
        Arrays.sort(randomNumbers);
        boolean returnedFlag = true;
        for (int i = 0; i < playerNumbers.length; i++) {
            for (int j = 0; j < randomNumbers.length; j++) {
                if (playerNumbers[j] != randomNumbers[j]) {
                    returnedFlag = false;
                    break;
                }
            }
        }
        return returnedFlag;
    }

    private void showStartingInstructions() {
        System.out.println(Messenger.GIVE_SIX_NUMBERS);
    }

    //TODO spróbuj wykonać jedną klasę Validatora który sprawdzi oba warunki czyli połączy ReplayChecker i ValidatorOfRange
    //TODO spróbuj stworzyć klasę która będzie generować liczby na podstawie konstruktora albo Random albo BufferedReader
}
