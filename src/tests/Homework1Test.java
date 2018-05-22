package tests;

import homework1.Utils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Homework1Test {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getLessThanAverageThrowsIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        Utils.getLessThanAverage(null);
    }

    @Test
    public void getLessThanAverageReturnsEmptyArray() {
        String[] emptyArray = {};
        String[] actual = Utils.getLessThanAverage(emptyArray);
        Assert.assertTrue(actual.length == 0);
    }

    @Test
    public void getLessThanAverageWithArrayOfEmptyStringsReturnsEmptyArray() {
        String[] input = {"", "", "", "", "", ""};
        String[] actual = Utils.getLessThanAverage(input);
        Assert.assertTrue(actual.length == 0);
    }

    @Test
    public void getLessThanAverageWithArrayOfEmptyStringsButOneReturnsArrayOfEmptyStrings() {
        String[] input = {"", "", "", "", "", "notEmpty"};
        String[] expected = {"", "", "", "", ""};
        String[] actual = Utils.getLessThanAverage(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getLessThanAverageReturnsArrayOfStringsWithOneCharacter() {
        String[] input = {"1", "1", "1", "12characters", "12characters", "12characters"};
        String[] expected = {"1", "1", "1"};
        String[] actual = Utils.getLessThanAverage(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getLessThanAverageReturnsEmptyArrayWhenAllTheStringsHaveEqualSizes() {
        String[] input = {"1", "1", "1", "1", "1", "1"};
        String[] actual = Utils.getLessThanAverage(input);
        Assert.assertTrue(actual.length == 0);
    }
}