public class Finder {

    private static final char PATHWAY_COLOR = '.';
    private static final char WALL_COLOR = 'W';
    private static final char BLOCKED_COLOR = 'B';
    private static final char PATH_COLOR = 'p';

    public static boolean findMazePath(int x, int y, char[][]maze, int N) {
        if (x<0 || y<0 || x>=N || y>=N) {return false;}
        else if (maze[x][y] != PATHWAY_COLOR) {return false;}
        else if (x == N-1 && y == N-1) {
            maze[x][y] = PATH_COLOR;
            return true;
        }
        else {
            maze[x][y] = PATH_COLOR;
            if (findMazePath(x - 1, y, maze, N) ||
                    findMazePath(x, y + 1, maze, N) ||
                    findMazePath(x + 1, y, maze, N) ||
                    findMazePath(x, y - 1, maze, N)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOR;
            return false;
        }

    }

    static boolean pathFinder(String maze1) {
        // Your code here!!

        int N = 0;
        int count = 0;
        boolean result;
        char[] chs = maze1.toCharArray();

        for(int i=0; i<chs.length; i++) {
            if(chs[i]=='\n') {N=i; break;}
        }
        if(N==0) {return true;}
        char[][] maze = new char[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(chs[count]=='\n')
                    count++;
                maze[i][j] = chs[count];
                count++;
            }
        }

        findMazePath(0,0,maze,N);

        if(maze[N-1][N-1]==PATH_COLOR) {return true;}
        else {return false;}

    }
}