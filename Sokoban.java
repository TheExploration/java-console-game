
import java.util.Scanner;


public class Sokoban {
        static char[][] ResetBoard = {
            {'#','#','#','#','#','#','#','#','#'},
            {'#','#','-','-','-','-','O','-','#'},
            {'#','#','.','.','.','#','#','#','#'},
            {'#','#','X','X','X','#','#','#','#'},
            {'#','#','-','-','-','-','#','#','#'},
            {'#','#','-','-','-','-','#','#','#'},
            {'#','#','#','#','#','#','#','#','#'},
            
        };
    static char[][] Board = {
            {'#','#','#','#','#','#','#','#','#'},
            {'#','#','-','-','-','-','O','-','#'},
            {'#','#','.','.','.','#','#','#','#'},
            {'#','#','X','X','X','#','#','#','#'},
            {'#','#','-','-','-','-','#','#','#'},
            {'#','#','-','-','-','-','#','#','#'},
            {'#','#','#','#','#','#','#','#','#'},
            
        };
    static char move;
    static char prev_move;
    static boolean win = false;
    static int playerY = 1;
    static int playerX = 6;
    static int moves = 0;
    
    public static void main(String[] args) {
        
        
        printGrid();
        intro();
        
        while (!win) {
            getCommand();
            movePlayer();
            System.out.println("\n \n \n \n \n \n \n \n\n \n \n \n \n \n \n \n");            
            for(int i=0;i<Board[0].length*3;i++) System.out.print("$");
            System.out.println('\n');
            printGrid();
            moves++;
            checkWin();
        }
        System.out.println('\n');
        System.out.println("You Win! Moves: " + moves);

        
    }
    public static void intro() {

    System.out.println();
    System.out.println("~~~~~ Welcome to Sokoban ~~~~~\n");
    System.out.println("Puzzle game where you push boxes 'X' to targets 'T'! Player is 'O\n");
    System.out.println("Controls: w = UP, a = LEFT, s = DOWN, d = RIGHT, q = QUIT, r = RESTART\n");
    System.out.println("Type in letter and press enter to move. \nOr simply leave blank and just press enter to continue movement.\n");

    }
    public static void printGrid() {
        if (Board[2][2] != 'X' && Board[2][2] != 'O') {
            Board[2][2] = '.';
        }
        
        if (Board[2][3] != 'X' && Board[2][3] != 'O') {
            Board[2][3] = '.';
        }
        if (Board[2][4] != 'X' && Board[2][4] != 'O') {
            Board[2][4] = '.';
        }
        
         for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                System.out.printf(Board[row][col] + " ");
            }
            System.out.println();
            
        }
    }
    public static void getCommand() {

        Scanner scanner = new Scanner(System.in);
        
        try {
          move = scanner.nextLine().charAt(0);

          
          if(move=='\n') move = prev_move;

          
          else prev_move = move;

          
        } catch (StringIndexOutOfBoundsException e) {
          
          move = prev_move;
        }
    }
    public static void movePlayer() {
        if (move == 'r') {
            System.out.println("Restart!");
            for(int i =0; i < Board.length; i++) {
                for (int j = 0; j < Board[0].length; j++) {
                    Board[i][j] = ResetBoard[i][j];
                }
            }
            
            playerY = 1;
            playerX = 6;
            moves = 0;
        }
        
        if (move == 'q') {
            System.out.println("Game Over. " + "Moves: " + moves);
            System.exit(0);
        }
        if (move == 'a' && Board[playerY][playerX-1] != '#') {
            if (Board[playerY][playerX-1] == 'X' && (Board[playerY][playerX - 2] == '-' || Board[playerY][playerX - 2] == '.')) {
                Board[playerY][playerX] = '-';
                Board[playerY][playerX - 1] = 'O';
                Board[playerY][playerX - 2] = 'X';
                playerY = playerY;
                playerX -= 1;
            }
            if (Board[playerY][playerX-1] == '-' || Board[playerY][playerX-1] == '.') {
                Board[playerY][playerX] = '-';
                Board[playerY][playerX-1] = 'O';
                playerY = playerY;
                playerX -= 1;
            }
        }
        if (move == 'w' && Board[playerY-1][playerX] != '#') {
            if (Board[playerY-1][playerX] == 'X' && (Board[playerY-2][playerX] == '-' || Board[playerY-2][playerX] == '.')) {
                Board[playerY][playerX] = '-';
                Board[playerY-1][playerX] = 'O';
                Board[playerY-2][playerX] = 'X';
                playerY -= 1;
                playerX = playerX;
            }
            if (Board[playerY-1][playerX] == '-' || Board[playerY-1][playerX] == '.') {
                Board[playerY][playerX] = '-';
                Board[playerY-1][playerX] = 'O';
                playerY -= 1;
                playerX = playerX;
            }
        }
        if (move == 'd' && Board[playerY][playerX+1] != '#') {
            if (Board[playerY][playerX+1] == 'X' && (Board[playerY][playerX + 2] == '-' || Board[playerY][playerX + 2] == '.')) {
                Board[playerY][playerX] = '-';
                Board[playerY][playerX + 1] = 'O';
                Board[playerY][playerX + 2] = 'X';
                playerY = playerY;
                playerX += 1;
            }
            if (Board[playerY][playerX+1] == '-' || Board[playerY][playerX+1] == '.') {
                Board[playerY][playerX] = '-';
                Board[playerY][playerX+1] = 'O';
                playerY = playerY;
                playerX += 1;
            }
        }
        if (move == 's' && Board[playerY+1][playerX] != '#') {
            if (Board[playerY+1][playerX] == 'X' && (Board[playerY+2][playerX] == '-' || Board[playerY+2][playerX] == '.')) {
                Board[playerY][playerX] = '-';
                Board[playerY+1][playerX] = 'O';
                Board[playerY+2][playerX] = 'X';
                playerY += 1;
                playerX = playerX;
            }
            if (Board[playerY+1][playerX] == '-' || Board[playerY+1][playerX] == '.') {
                Board[playerY][playerX] = '-';
                Board[playerY+1][playerX] = 'O';
                playerY += 1;
                playerX = playerX;
            }
        }      
    }
    public static void checkWin() {
        if (Board[2][2] == 'X' && Board[2][3] == 'X' && Board[2][4] == 'X') {
        win = true;
        
        }
    }
}
