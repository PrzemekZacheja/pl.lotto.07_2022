package pl.lotto;

import java.util.*;

public class Lotto implements Game {
    private static final String START_INSTRUCTION = "Write 6 unique numbers from 1 to 99";
    private static final String WINNER = "You Win";
    private static final String LOOSE = "You loose";
    private final Scanner scanner = new Scanner(System.in);
    Random r = new Random();


    @Override
    public void play() {
        showInstructionOnStart();
        Set<Integer> numbersFromPlayer = getNumbersFromPlayer(scanner);
        printSet(numbersFromPlayer);
        Set<Integer> randomNumbers = getRandomNumbers(r);
        printSet(randomNumbers);
        System.out.println(isTheSame(numbersFromPlayer, randomNumbers)? WINNER: LOOSE);
    }

    private void printSet(Set<Integer> numbersFromPlayer) {
        for (Integer integer : numbersFromPlayer) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private void showInstructionOnStart() {
        System.out.println(START_INSTRUCTION);
    }

    Set<Integer> getNumbersFromPlayer(Scanner scanner) {
        String getNumbersFromPlayer = scanner.nextLine();
        String[] arraysString = getNumbersFromPlayer.split("\\s");
        Set<Integer> returnedArray = changeStringsArrayToIntsArrays(arraysString);
        scanner.close();
        return returnedArray;
    }

    Set<Integer> changeStringsArrayToIntsArrays(String[] arraysString) {
        Set<Integer> returnedArray = new HashSet<>();
        for (String s : arraysString) {
            returnedArray.add(Integer.valueOf(s));
        }
        return returnedArray;
    }

    Set<Integer> getRandomNumbers(Random r) {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size()<6){
            numbers.add(r.nextInt(99+1));
        }
        return numbers;
    }

    private boolean isTheSame(Set<Integer> numbersFromPlayer, Set<Integer> randomNumbers) {
        return numbersFromPlayer.containsAll(randomNumbers);
    }
}
