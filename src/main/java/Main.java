public class Main {
    public static void main(String[] args) {
        TicTacToeManager ticTacToeManager = new TicTacToeManager();
        ticTacToeManager.start();
    }
}

/*
Present menu to user
  Start the game
    - create the board
    - create player 1 and 2
      - Take player names as user input
      - Take player symbol as an input
    - ask player to make a move
    - check every move for win or draw condition
    - print the board for every move
  Exit
 */