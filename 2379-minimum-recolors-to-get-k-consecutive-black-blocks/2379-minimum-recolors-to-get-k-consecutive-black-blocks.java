class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;

        // Count whites in first window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }

        int min = white;

        // Slide the window
        for (int i = k; i < blocks.length(); i++) {

            if (blocks.charAt(i - k) == 'W') {
                white--;
            }

            if (blocks.charAt(i) == 'W') {
                white++;
            }

            min = Math.min(min, white);
        }

        return min;
    }
}