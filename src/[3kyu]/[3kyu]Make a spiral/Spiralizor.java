public class Spiralizor {

    public static int[][] spiralize(int size) {

        int N = size;
        int inc = 1;
        int a = 0, b = -1;
        int[][] array = new int[size][size];

        for (; size > 0; ) {
            for (int i = 0; i < size; i++) {
                b += inc;
                array[a][b] = 1;
            }

            if (size == N) { size--; }
            else { size -= 2; }

            for (int i = 0; i < size; i++) {
                a += inc;
                array[a][b] = 1;
            }
            if(size == 1){ break; }
            inc *= -1;
        }

        return array;
    }
}