class Solution {
    public int minimumRecolors(String blocks, int k) {
          int sum = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                sum++;
            }
        }

        int min = sum;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                sum--;
            }
            if (blocks.charAt(i) == 'W') {
                sum++;
            }

            min = Math.min(min, sum);
        }

        return min;
        
    }
}