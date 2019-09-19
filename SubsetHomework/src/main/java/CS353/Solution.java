package CS353;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList();
        // input checking
        // Is the array empty??
        // Does the array have more than 1 element?
        if (nums.length == 0) {
            return results;
        } else if (nums.length == 1) {
            List<Integer> subset = new ArrayList<Integer>();
            subset.add(nums[0]);
            results.add(new ArrayList<Integer>());
            results.add(subset);
            return results;
        }
        //System.exit(-1);
        // possibly need to sort nums
        Arrays.sort(nums);

        // create subset
        List<Integer> subset = new ArrayList<Integer>();

        // Call helper function to do recursion
        helper(nums, 0, subset, results);
        return results;
    }

    private void helper(int[] nums, int offset, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset)); //Creates new memory for our results
        for (int i = offset; i < nums.length; i++){
            System.out.println(i);
            subset.add(nums[i]);
            helper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }

}
