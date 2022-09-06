package task2;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void sum() {
        int[] nums = {3, 4, 2, 7};
        int target = 10;
        int[] expected = {3, 7};
        Assert.assertArrayEquals(expected, Main.sum(nums, target));
    }

    @Test
    public void sum1() {
        Assert.assertArrayEquals(new int[]{1, 1}, Main.sum(new int[]{1, 3, 1}, 2));
    }
}