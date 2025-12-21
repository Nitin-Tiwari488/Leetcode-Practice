class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;          // number of strings (rows)
        int m = strs[0].length();     // length of each string (columns)

        // Track which rows are already confirmed to be in order
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        // Iterate column by column
        for (int col = 0; col < m; col++) {
            boolean needDelete = false;

            // Compare characters in this column row by row
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row]) { // only check rows not yet confirmed
                    char c1 = strs[row].charAt(col);
                    char c2 = strs[row + 1].charAt(col);

                    if (c1 > c2) {
                        // Order breaks → must delete this column
                        needDelete = true;
                        break;
                    }
                }
            }

            if (needDelete) {
                deletions++; // delete this column
            } else {
                // Mark rows that are now confirmed sorted
                for (int row = 0; row < n - 1; row++) {
                    if (!sorted[row]) {
                        char c1 = strs[row].charAt(col);
                        char c2 = strs[row + 1].charAt(col);
                        if (c1 < c2) {
                            sorted[row] = true;
                        }
                    }
                }
            }
        }

        return deletions;
    }
}
