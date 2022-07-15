package pl.lotto.validator;

public class ValidatorOfRange {

     private final int minRange;
     private final int maxRange;

    public ValidatorOfRange(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public boolean validate(int numberFromReader) {
        return numberFromReader >= minRange && numberFromReader <= maxRange;
    }
}
