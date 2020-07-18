package testpackage;

import java.io.IOException;
import java.util.Scanner;

import modelpackage.Board;
import modelpackage.Result;

public class TicTacToeTest {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("Player First, enter your name.");
		String name1 = input.next();

		System.out.println("Player Second, enter your name:");
		String name2 = input.next();

		Board mygame = new Board(name2, name2);

		while (mygame.winner() == Result.INCOMPLETE) {

			int r, c;
			boolean done = false;

			do {

				mygame.printboard();

				System.out.print(mygame.getCurrentPlayer());
				System.out.print(", Enter the row(0-2) and column(0-2) ");
				System.out.println("of your move.");

				r = input.nextInt();
				c = input.nextInt();
				if (!mygame.index(r, c))
					System.out.println("Sorry, those are invalid entries.");
				else {
					if (!mygame.Move(r, c))
						System.out.println("Sorry, that square is taken.");
					else
						done = true;
				}
			} while (!done);

			mygame.changeTurn();
		}
		mygame.printboard();

		Result win = mygame.winner();

		// Check win with TIE.
		if (win == Result.TIE)
			System.out.println("Both of you played to a tie.");
		else {

			// Figure out who won by converting the status to the player name.
			System.out.print("Congratulations, " + mygame.whoWon(win));
			System.out.println(", you have won the game.");
		}

	}
}