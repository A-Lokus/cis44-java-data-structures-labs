public class MazeSolver {
    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public boolean solve(){
        int startRow = -1;
        int startCol = -1;
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 'S'){
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if(startRow != -1){
            boolean solved = solve(startRow, startCol);
            maze[startRow][startCol] = 'S';
            return solved;
        }
        return false;
    }

    public boolean solve(int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }
        if (maze[row][col] == 'F') {
            return true;
        }

        char temp = maze[row][col];

            maze[row][col] = '.';
        boolean pathFound = (solve(row-1, col) || solve(row, col+1) || solve(row+1, col) || solve(row, col-1));
        if(pathFound){return true;}
        maze[row][col] = temp;
        return false;
    }

    public static void main(String[] args) {
        char[][] mazeToSolve1 = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        char[][] mazeToSolve2 = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', '#', '#', '#', ' ', '#', 'F', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', 'S', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver1 = new MazeSolver(mazeToSolve1);
        MazeSolver solver2 = new MazeSolver(mazeToSolve2);


        System.out.println("Original Maze 1:");
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver1.printMaze();

        System.out.println("Original Maze 2:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver2.printMaze();
    }
}