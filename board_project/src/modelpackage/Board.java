package modelpackage;

public class Board {

	private Mark[][] board;
	private String[] players;
	private Mark turn;
	int numMoves;

	public Board(String player1, String player2) {

		board = new Mark[3][3];

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = Mark.NULL;

		turn = Mark.X;
		numMoves = 0;
		players = new String[2];
		players[0] = player1;
		players[1] = player2;
	}

	public boolean Move(int row, int column) {
		if ((board[row][column] == Mark.NULL) && index(row, column)) {
			board[row][column] = turn;
			numMoves++;
			return true;
		} else
			return false;
	}

	public boolean index(int row, int column) {
		if ((row < 0) || (column < 0))
			return false;
		if ((row > 2) || (column > 2))
			return false;
		return true;
	}

	public void changeTurn() {
		if (turn == Mark.X)
			turn = Mark.O;
		else
			turn = Mark.X;
	}

	public String getCurrentPlayer() {

		if (turn == Mark.X)
			return players[0];
		return players[1];
	}

	public void printboard() {
		System.out.println("\t0 1 2");
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "\t");
			for (int j = 0; j < 3; j++)
				System.out.print(getChar(board[i][j]) + "  ");

			System.out.println();
		}
	}

	public char getChar(Mark m) {
		if (m == Mark.X)
			return 'X';
		else if (m == Mark.O)
			return 'O';
		else
			return '_';
	}

	public Result winner() {

		for (int i = 0; i < 3; i++)
			if (SameArray(board[i]))
				return convertResult(board[i][0]);

		for (int i = 0; i < 3; i++) {
			if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]))
				return convertResult(board[0][i]);

			if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
				return convertResult(board[0][0]);

			if ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2]))
				return convertResult(board[2][0]);
		}

		if (numMoves == 9)
			return Result.DRAW;

		return Result.INCOMPLETE;
	}

	public Result convertResult(Mark m) {
		if (m == Mark.X)
			return Result.XWINS;

		else if (m == Mark.O)
			return Result.OWINS;

		return Result.INCOMPLETE;
	}

	private static boolean SameArray(Mark[] word) {

		Mark check = word[0];
		for (int i = 1; i < word.length; i++)
			if (check != word[i])
				return false;
		return true;
	}

	public String whoWon(Result r) {
		if (r == Result.XWINS)
			return players[0];

		else
			return players[1];
	}
}
