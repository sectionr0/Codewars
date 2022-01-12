public class Finder {

    private static class Pos {
        final int x, y;
        Pos(int x, int y) { this.x = x; this.y = y; }
        Pos[] neighbours() { return new Pos[]{ new Pos(x-1,y), new Pos(x+1,y), new Pos(x,y-1), new Pos(x,y+1) }; }
        boolean onPath(char[][]g) { return x >= 0 && x < g[0].length && y >= 0 && y < g.length && g[y][x] == '.'; }
    }

    static boolean pathFinder(String maze) {
        final String rows[] = maze.split("\n");
        final char[][] grid = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) grid[i] = rows[i].toCharArray();
        return findExit(new Pos(0,0), grid);
    }

    private static boolean findExit(Pos p, char[][]g) {
        if (p.x == g.length-1 && p.x == p.y) return true; // We made it to the exit!
        if (!p.onPath(g)) return false;
        g[p.y][p.x] = 'B';  // drop a breadcrumb
        final Pos[] n = p.neighbours();
        return findExit(n[0],g) | findExit(n[1],g) | findExit(n[2],g) | findExit(n[3],g);
    }

}