package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	
	Squarelotron sq1, sq2, sq3, sq4, sq5, sq6;
	@Before
	public void setUp() throws Exception {
		sq1 = new Squarelotron(4);
		sq2 = new Squarelotron(3);
		int[] array1 = {1,2,3,4,5,6,7,8,9};
		sq3 = new Squarelotron(array1);
		int[] array2 = {5,6,3,4};
		sq4 = new Squarelotron(array2);
	}

	@Test
	public void testSquarelotronInt() {
		sq1 = new Squarelotron(4);
		int[] array2 = {5,6,7,8};
		assertArrayEquals(array2, sq1.squarelotron[1]);
		assertEquals(5, sq2.squarelotron[1][1]);
	}

	@Test
	public void testSquarelotronIntArray() {
		int[] array1 = {1,2,3,4,5,6,7,8,9};
		sq3 = new Squarelotron(array1);
		int[] array2 = {7,8,9};
		assertArrayEquals(array2, sq3.squarelotron[2]);
		assertEquals(3, sq3.squarelotron[0][2]);
	}

	@Test
	public void testNumbers() {
		int[] array2 = sq2.numbers();
		int[] array3 = {1,2,3,4,5,6,7,8,9};
		assertArrayEquals(array3, array2);
		int[] array4 = sq4.numbers();
		assertEquals(3, array4[2]);
	}

	@Test
	public void testUpsideDownFlip() {
		sq5 = sq1.upsideDownFlip(2);
		assertEquals(10, sq5.squarelotron[1][1]);
		assertEquals(11, sq5.squarelotron[1][2]);
		assertEquals(6, sq5.squarelotron[2][1]);
		assertEquals(7, sq5.squarelotron[2][2]);
	}

	@Test
	public void testLeftRightFlip() {
		sq5 = sq2.leftRightFlip(3);
		assertEquals(5, sq5.squarelotron[1][1]);
		sq6 = sq2.leftRightFlip(1);
		assertEquals(1, sq6.squarelotron[0][2]);
		assertEquals(4, sq6.squarelotron[1][2]);
		assertEquals(7, sq6.squarelotron[2][2]);
		assertEquals(3, sq6.squarelotron[0][0]);
		assertEquals(6, sq6.squarelotron[1][0]);
		assertEquals(9, sq6.squarelotron[2][0]);
	}

	@Test
	public void testInverseDiagonalFlip() {
		sq5 = sq4.inverseDiagonalFlip(1);
		assertEquals(4, sq5.squarelotron[0][0]);
		assertEquals(6, sq5.squarelotron[0][1]);
		assertEquals(3, sq5.squarelotron[1][0]);
		assertEquals(5, sq5.squarelotron[1][1]);
	}

	@Test
	public void testMainDiagonalFlip() {
		sq5 = sq4.mainDiagonalFlip(1);
		assertEquals(5, sq5.squarelotron[0][0]);
		assertEquals(3, sq5.squarelotron[0][1]);
		assertEquals(6, sq5.squarelotron[1][0]);
		assertEquals(4, sq5.squarelotron[1][1]);
	}

	@Test
	public void testSideFlip() {
		sq5 = sq1.sideFlip("right");
		int[] array3 = {1,2,4,3};
		int[] array4 = {5,6,8,7};
		assertArrayEquals(array3, sq5.squarelotron[0]);
		assertArrayEquals(array4, sq5.squarelotron[1]);
	}

	@Test
	public void testRotateRightOnce() {
		sq1.rotateRightOnce();
		int[] array3 = {13,9,5,1};
		int[] array4 = {14,10,6,2};
		assertArrayEquals(array3, sq1.squarelotron[0]);
		assertArrayEquals(array4, sq1.squarelotron[1]);
	}

	@Test
	public void testRotateRight() {
		sq1.rotateRight(3);
		int[] array3 = {4,8,12,16};
		assertArrayEquals(array3, sq1.squarelotron[0]);
	}
	
	@Test
	public void testSame(){
		assertTrue(sq2.same(sq3));
		assertFalse(sq2.same(sq4));
	}

	@Test
	public void testEqualsObject() {
		assertTrue(sq2.equals(sq3));
		assertFalse(sq2.equals(sq1));
	}

	@Test
	public void testToString() {
		String newString = sq4.toString();
		assertTrue(newString.equals("5\t6\t\n3\t4\t\n"));
	}

}
