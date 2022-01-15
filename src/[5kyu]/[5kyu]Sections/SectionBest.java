import java.lang.Math;
class Section {
    public static int c(long k) {
        long sq = (long) Math.floor(Math.sqrt(k));
        if (sq * sq != k) return 0;
        int i = 2;
        long num = k * sq;
        int ans = 1;
        while (num > 1) {
            int cnt = 0;
            while (num % i == 0) {
                num /= i;
                cnt++;
            }
            ans *= (cnt + 1);
            i++;
        }
        return ans;
    }
}