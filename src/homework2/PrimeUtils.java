package homework2;

public class PrimeUtils {
    private static final int minPrimeNumber = 2;

    public static int getMaxBinaryOnes(int maxNumber) {
        if (maxNumber < minPrimeNumber) {
            throw new IllegalArgumentException("Argument 'maxNumber' must be more than 1.");
        }

        if (maxNumber == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        int maxCount = -1;
        int count;
        int resultValue = minPrimeNumber;
        for (int i = minPrimeNumber; i <= maxNumber; i++) {
            count = Integer.bitCount(i);
            if (count <= maxCount) {
                continue;
            }
            if (!isPrime(i)) {
                continue;
            }
            resultValue = i;
            maxCount = count;
        }
        return resultValue;
    }

    private static boolean isPrime(int number) {
        if (number > minPrimeNumber && number % 2 == 0) {
            return false;
        }
        int max = (int)Math.sqrt(number) + 1;
        for (int i = 3; i < max; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
