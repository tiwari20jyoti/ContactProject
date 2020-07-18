
package modelpackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testBoard() {
		// Arrange
		String expectedplayer1 = "Jyoti";
		String expectedplayer2 = "abc";

		// Act

		Board b = new Board("Jyoti", "abc");

		// Assert
		assertEquals(expectedplayer1, b.getCurrentPlayer());
		// assertEquals(expectedplayer2, b.getCurrentPlayer());
		assertEquals(expectedplayer2, b.getCurrentPlayer());

	}

	@Test
	void testMove() {
		fail("Not yet implemented");
	}

	@Test
	void testIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testChangeturn() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintboard() {
		fail("Not yet implemented");
	}

	@Test
	void testWinner() {
		fail("Not yet implemented");
	}

	@Test
	void testConvertResult() {
		fail("Not yet implemented");
	}

	@Test
	void testWhoWon() {
		fail("Not yet implemented");
	}

}
