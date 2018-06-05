package tests.homework2;

import homework2.PrimeUtils;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Homework2Test {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getMaxBinaryOnesThrowsIllegalArgumentExceptionOnNegativeInput() {
        exception.expect(IllegalArgumentException.class);
        PrimeUtils.getMaxBinaryOnes(-1);
        exception.expect(IllegalArgumentException.class);
        PrimeUtils.getMaxBinaryOnes(Integer.MIN_VALUE);
    }

    @Test
    public void getMaxBinaryOnesThrowsIllegalArgumentExceptionOnZeroOrOneInput() {
        exception.expect(IllegalArgumentException.class);
        PrimeUtils.getMaxBinaryOnes(0);
        exception.expect(IllegalArgumentException.class);
        PrimeUtils.getMaxBinaryOnes(1);
    }

    @Test
    public void getMaxBinaryOnesReturnsProperPrime() {
        int expected = 31;
        int actual = PrimeUtils.getMaxBinaryOnes(100);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaxBinaryOnesReturnsProperPrimeForIntegerMaxValueArgument() {
        int expected = Integer.MAX_VALUE;
        int actual = PrimeUtils.getMaxBinaryOnes(Integer.MAX_VALUE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMaxBinaryOnesReturnsProperPrimeForIntegerMaxValueMinusOneArgument() {
        int expected = 1073479679;
        int actual = PrimeUtils.getMaxBinaryOnes(Integer.MAX_VALUE - 1);
        Assert.assertEquals(expected, actual);
    }
}