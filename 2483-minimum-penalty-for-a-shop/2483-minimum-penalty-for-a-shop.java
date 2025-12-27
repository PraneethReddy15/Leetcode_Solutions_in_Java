class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial penalty: shop closes at hour 0
        // All 'Y' are after closing → penalty
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Move closing hour from 1 → n
        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);

            // If we move past hour i:
            // 'Y' now becomes open (penalty -1)
            // 'N' now becomes open (penalty +1)
            if (c == 'Y') penalty--;
            else penalty++;

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
