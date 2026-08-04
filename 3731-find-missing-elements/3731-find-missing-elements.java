class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;

        for (int num : nums) {
            large = Math.max(large, num);
            small = Math.min(small, num);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = small + 1; i < large; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}