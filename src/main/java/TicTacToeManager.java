import java.util.Scanner;

public class TicTacToeManager {
	private char[][] board;
	private Player playerOne;
	private Player playerTwo;
	private Scanner scanner = new Scanner(System.in);

	public void start() {

		pickMenuOption();
		playerOne = createPlayer(1);
		playerTwo = createPlayer(2);
        
		//
		while(true) {
			if(checkWin(playerOne.getSymbol())) {
				System.out.println("Player 1 Won");
				break;
			}
			else if(checkWin(playerTwo.getSymbol())){
				System.out.println("Player 2 Won");
				break;
			}
			else if(checkDraw()){
				System.out.println("it's a draw");
				break;
			}
		}
		
		
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

		} while (!strInput.equals("1")); // todo make verification
	}

	public void displayMenu() {
		System.out.println("1. Play\n2. Exit");
	}

	public void createBoard() {
		board = new char[][] { { '.', '.', '.' },
			                   { '.', '.', '.' },
			                   { '.', '.', '.' } };
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void makeMove(Player player) {
		int intRow;
		String strRow;
		int intColumn;
		String strColumn;
		do {
			do {
				System.out.print("Enter the row number: ");
				strRow = scanner.nextLine();
				if (isSingleDigit(strRow)) {
					intRow = Integer.parseInt(strRow) - 1; // user input will be from 1-3 and we'll check from 0-2
					if (isInBounds(intRow)) {
						break;
					}
				}
			} while (true);

			do {
				System.out.print("Enter the column number: ");
				strColumn = scanner.nextLine();
				if (isSingleDigit(strColumn)) {
					intColumn = Integer.parseInt(strColumn) - 1; // user input will be from 1-3 and we'll check from 0-2
					if (isInBounds(intColumn)) {
						break;
					}
				}
			} while (true);
			if (board[intRow][intColumn] == '.') {
				board[intRow][intColumn] = player.getSymbol();
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

	public boolean isInBounds(int num) {
		if (num >= 0 && num < 3) {
			return true;
		} else {
			System.out.println("Input needs to be a positive number");
			return false;
		}
	}

	public boolean checkWin(char symbol) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
				return true;
			}

			if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
				return true;
			}
		}

		if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
			return true;
		}
		if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkDraw() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j]=='.') {
					return false;
				}
			}
		}
		return true;
	}
}

    
