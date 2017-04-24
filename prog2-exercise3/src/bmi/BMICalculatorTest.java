package bmi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BMICalculatorTest {

	BMICalculator bmiCalculator;

	@Before
	public void setUp() throws Exception {
		// Vorbereiten
		bmiCalculator = new BMICalculator(174, 65);
	}

	@Test
	public void testCalculateBMI() {
		// Durchführen
		double result = bmiCalculator.calculateBMI();

		// Bewerten
		assertEquals(21.469, result, 0.001);
	}

	@Test
	public void testBMICategory() {
		// Vorbereiten
		BMICalculator bmiCalculatorUnderWeight = new BMICalculator(174, 40);
		BMICalculator bmiCalculatorNormalWeight = new BMICalculator(174, 70);
		BMICalculator bmiCalculatorOverWeight = new BMICalculator(174, 85);
		BMICalculator bmiCalculatorObesity = new BMICalculator(174, 105);

		// Durchführen
		int underWeight = bmiCalculatorUnderWeight.getBMICategory();
		int normalWeight = bmiCalculatorNormalWeight.getBMICategory();
		int overWeight = bmiCalculatorOverWeight.getBMICategory();
		int obesity = bmiCalculatorObesity.getBMICategory();

		// Bewerten
		assertEquals(0, underWeight);
		assertEquals(1, normalWeight);
		assertEquals(2, overWeight);
		assertEquals(3, obesity);
	}

	@Test
	public void testCalculateBMIWithAge() {
		// Durchführen
		int underWeightAge65 = bmiCalculator.getBMICategory(65);
		int normalWeightAge20 = bmiCalculator.getBMICategory(20);

		assertEquals(0, underWeightAge65);
		assertEquals(1, normalWeightAge20);
	}

}
