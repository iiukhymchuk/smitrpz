package homework3.entities;

public class TurnstileSuccessRate {
    private static int success;
    private static int nonSuccess;

    public TurnstileSuccessRate(int success, int nonSuccess) {
        this.success = success;
        this.nonSuccess = nonSuccess;
    }

    public TurnstileSuccessRate() {
        success = 0;
        nonSuccess = 0;
    }

    public static int getSuccesses() {
        return success;
    }

    public static int getNonSuccesses() {
        return nonSuccess;
    }

    public static void increaseSuccesses() {
        success++;
    }

    public static void increaseNonSuccesses() {
        nonSuccess++;
    }
}
