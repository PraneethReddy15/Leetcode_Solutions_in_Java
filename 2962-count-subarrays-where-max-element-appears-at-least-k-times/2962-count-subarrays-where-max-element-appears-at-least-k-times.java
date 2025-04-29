// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         int max=-1;
//         for(int i=0;i<nums.length;i++)
//         {
//             if(nums[i]>max) max= nums[i];
//         }
//         long count=0;
//         int w=k;
//         while(w<=nums.length)
//         {
//             for(int i=0;i<=nums.length-w;i++)
//             {
//                 int c=0;
//                 for(int j=i;j<i+w;j++)
//                 {
//                     if(nums[j]==max)
//                     {
//                         c++;
//                     }
//                 }
//                 if(c>=k) count++;
//             }
//             w++;
//         }
//         return count;
//     }
// }

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }

        long count = 0;
        int n = nums.length;
        int freq = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) freq++;

            // When count of max ≥ k, all subarrays starting from left to right are valid
            while (freq >= k) {
                // All subarrays [left..right], [left+1..right], ..., [right..right] are valid
                count += n - right;
                if (nums[left] == max) freq--;
                left++;
            }
        }

        return count;
    }
}
