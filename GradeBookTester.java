/*
 * Name: Alex Kim
 * Professor Eivazi
 * Class: GradeBookTester
 * Due Date: 2/7/25
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	//define two private gradebooks
    private GradeBook gradeBook_1;
    private GradeBook gradeBook_2;

	@BeforeEach
	void setUp() throws Exception {
		//creating with 5 available grades (empty)
		gradeBook_1 = new GradeBook(5);
		gradeBook_2 = new GradeBook(5);
		
		//adding 3 grades to gradebook 1
		gradeBook_1.addScore(90.5);
		gradeBook_1.addScore(99.5);
		gradeBook_1.addScore(95.0);
		
		//adding only 2 grades to gradebook 2
		gradeBook_2.addScore(97.0);
		gradeBook_2.addScore(100.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook_1 = null;
		gradeBook_2 = null;
	}

	@Test
	void testAddScore() {	
		
		//adding scores. these should pass as there are two left to fit in gradebook.
		 assertTrue(gradeBook_1.addScore(98.5));
	     assertTrue(gradeBook_1.addScore(95.5));
	     
	     //this one should fail because it already has 5 grades, making it full.
	     assertFalse(gradeBook_1.addScore(95.5));
	     
	     //this should pass
	     assertEquals(gradeBook_1.toString(), "90.5 99.5 95.0 98.5 95.5 ");
	     
	     //this one should fail because I added a fake grade at the end.
	     assertNotEquals(gradeBook_2.toString(), "97.0 100.0 99.5");
	}
	
	@Test
	void testSum() {
		assertEquals(gradeBook_1.sum(), 285.0);
		assertEquals(gradeBook_2.sum(), 197.0);
	}
	
	@Test
	void testMinimum() {
		assertEquals(gradeBook_1.minimum(), 90.5);
		assertEquals(gradeBook_2.minimum(), 97.0);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(gradeBook_1.finalScore(), 194.5);
		assertEquals(gradeBook_2.finalScore(), 100.0);
	}
}
