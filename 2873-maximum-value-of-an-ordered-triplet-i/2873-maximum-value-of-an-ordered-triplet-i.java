class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;

        int maxPrefix = nums[0];  // Track max value before j
        int[] maxSuffix = new int[n];  // Store max k values

        maxSuffix[n - 1] = nums[n - 1];  // Initialize last element

        // Compute maxSuffix from the end
        for (int k = n - 2; k >= 0; k--) {
            maxSuffix[k] = Math.max(maxSuffix[k + 1], nums[k]);
        }

        for (int j = 1; j < n - 1; j++) {  // Middle index
            res = Math.max(res, (long)(maxPrefix - nums[j]) * maxSuffix[j + 1]);
            maxPrefix = Math.max(maxPrefix, nums[j]);  // Update maxPrefix
        }

        return res;
    }
}
