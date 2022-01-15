public class Spiralizor {
    public static int[][] spiralize(int n) {
        int [][] a = new int[n][n];
        int n4 = n%4==0? 1: 0;
        for (int y = 0, c = 1; y <= n/2; y++) {
            for (int x = y; x < n -y; x++)
                a[y][x] = a[x][n-1 -y] = a[n-1 -y][n-1 -x] = a[n-1 -x][y] = c;
            c = 1-c;
            if (y+n4 < n/2) a[y+1][y] = c;
        }
        return a;
    }
}