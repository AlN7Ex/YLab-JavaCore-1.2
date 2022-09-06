/**
 * На вход подается массив и число.
 * Нужно вывести первую пару чисел, которые дают в сумме число.
 * [3, 4, 2, 7], 10 -> [3, 7]
 */

package task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] result = sum(new int[]{3, 4, 2, 7}, 10);
        System.out.println(Arrays.toString(result));


    }

    public static int[] sum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int expectedNum = target - nums[i];
            if (result.containsKey(expectedNum)) {
                return new int[]{expectedNum, nums[i]};
            } else {
                result.put(nums[i], i);
            }
        }
        return null;
    }
}
