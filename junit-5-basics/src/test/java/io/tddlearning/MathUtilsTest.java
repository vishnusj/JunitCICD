package io.tddlearning;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

class MathUtilsTest {
	
	MathUtils obj;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		obj  = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags() );
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning UP");
	}

	@Test
	@DisplayName("Testing Add Method")
	@Tag("Math")
	void testAdd() {		
		
		int expected = 3;
		int actual = obj.add(1, 2);
		assertEquals(expected, actual, "Adding method to add numbers");
		
	}

		
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("Math")
	void testSubtract() {
		//System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags() );
		
		int expected = 2;
		assumeTrue(expected == 1);
		int actual = obj.subtract(2, 1);
		assertEquals(expected, actual, "Subtracting method to subtract numbers");
		
	}
	
	@Test
	@Disabled
	@Tag("Math")
	void testDivide() {
		int expected = 2;
		int actual = obj.divide(4, 2);
		assertEquals(expected, actual, "Divide method to subtract numbers");
		//assertThrows(ArithmeticException.class, () -> obj.divide(2, 0), "Divide by zero should throw");
		
	}
	
	@Test
	@DisplayName("Multiplication")
	@Disabled
	@Tag("Math")
	void testMultiply() {
		//assertEquals(4, obj.multiply(2,2), "Return the product");
		assertAll(
				//() -> assertEquals(4, obj.multiply(2,2)),
				//() -> assertEquals(0, obj.multiply(2,0)),
				//() -> assertEquals(-2, obj.multiply(2,-1))
				);
	}


	@RepeatedTest(2)
	@Tag("Circle")
	void testComputeCircleRadius() {
		
		
		double area = (Math.PI * 10.0 * 10.0);
		assertEquals(area, obj.computeCircleArea(10.0), "Should return area of circle");
	}
}
