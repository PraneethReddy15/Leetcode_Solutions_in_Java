import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums);  // Step 1: Sort the array

        int[] dp = new int[n];      // dp[i] will store the size of the subset ending at nums[i]
        int[] prev = new int[n];    // prev[i] stores the index of the previous element in the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0; // Index of the largest element of the result subset

        // Step 2: Build the dp and prev arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Step 3: Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result);
        return result;
    }
}
