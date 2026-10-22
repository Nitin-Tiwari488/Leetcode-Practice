class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;

        long total = 0;
        for (int bean : beans) {
            total += bean;
        }

        long minRemove = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long removed = total - (long) beans[i] * (n - i);
            minRemove = Math.min(minRemove, removed);
        }

        return minRemove;
    }
}