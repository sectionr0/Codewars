public class SumOfSquares {
    public static int nSquaresFor(int n) {
        int[] d = new int[n + 1];
        for (int k = 0; k <= n; k++) {
            d[k] = k;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j] + 1);
            }
        }
        return d[n];
    }
}