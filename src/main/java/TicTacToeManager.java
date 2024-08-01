import java.util.Scanner;

public class TicTacToeManager {
    private char[][] board;
    private Player playerOne;
    private Player playerTwo;
    private Scanner scanner = new Scanner(System.in);


    public void start() {

        pickMenuOption();
        createPlayer(1);
        createPlayer(2);

        // creating the players

        // creating the board
        // print the board
        // ask player to move until the game is over

    }

    public Player createPlayer(int playerNum){
        String playerName;
        String symbol;
        do {
            System.out.print("Player " + playerNum + " name yourself: ");
            playerName = scanner.nextLine();
        } while (isValidName(playerName));

        do {
            System.out.print("Enter your symbol: ");
            symbol = scanner.nextLine();

        } while (1>2);
            return new Player(playerName, symbol.charAt(0));
    }

    public boolean isValidName(String name) {
        for (char c : name.toCharArray()) {
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                return false;
            }
        }
        return true;
    }

    public void pickMenuOption(){
        String strInput;

        do {
            displayMenu();

            // read user input
            strInput = scanner.nextLine();

            // check the chosen option
            if (strInput.equals("2")) {
                System.exit(0);
            }

        } while (!strInput.equals("1")); //todo make verification
    }


    public void displayMenu() {
        System.out.println("1. Play\n2. Exit");
    }


    public void createBoard() {
        board = new char[][]{
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
