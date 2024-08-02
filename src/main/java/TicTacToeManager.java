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

    public Player createPlayer(int playerNum) {
        String playerName;
        String symbol;
        do {
            System.out.print("Player " + playerNum + " name yourself: ");
            playerName = scanner.nextLine();
        } while (isEnglishAlphabet(playerName));

        do {
            System.out.print("Enter your symbol: ");
            symbol = scanner.nextLine();

        } while (isEnglishAlphabet(symbol));

        return new Player(playerName, symbol.charAt(0));
    }

    // Checks that characters are A-Z or a-z
    public boolean isEnglishAlphabet(String name) {
        for (char c : name.toCharArray()) {
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                return false;
            }
        }
        return true;
    }

    public void pickMenuOption() {
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

    public void makeMove() {
        int intRow;
        String strRow;
        int intColumn;
        String strColumn;
        do {
            do {
                System.out.print("Enter the row number: ");
                strRow = scanner.nextLine();
                if (isSingleDigit(strRow)) {
                    intRow = Integer.parseInt(strRow);
                    if (isPositiveNumber(intRow)) {
                        break;
                    }
                }
            } while (true);

            do {
                System.out.print("Enter the column number: ");
                strColumn = scanner.nextLine();
                if (isSingleDigit(strColumn)) {
                    intColumn = Integer.parseInt(strColumn);
                    if (isPositiveNumber(intColumn)) {
                        break;
                    }
                }
            } while (true);
            if (board[intRow][intColumn] == '.') {
                board[intRow][intColumn] = playerOne.getSymbol();
                break;
            } else {
                System.out.println("The position is already taken");
            }
        } while (true);
    }

    public boolean isSingleDigit(String input) {
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
            return true;
        } else {
            System.out.println("Input needs to be a single whole digit");
            return false;
        }
    }

    public boolean isPositiveNumber(int num) {
        if (num >= 0) {
            return true;
        } else {
            System.out.println("Input needs to be a positive number");
            return false;
        }
    }
}
