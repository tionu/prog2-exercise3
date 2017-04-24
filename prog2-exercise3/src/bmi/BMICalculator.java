package bmi;

import java.text.DecimalFormat;

public class BMICalculator {

	private int height;
	private int weight;

	public static final int UNDERWEIGHT = 0;
	public static final int NORMAL_WEIGHT = 1;
	public static final int OVERWEIGHT = 2;
	public static final int OBESITY = 3;

	/**
	 * Creates a new calculator for the body mass index
	 * 
	 * @param height
	 *            height in centimeters
	 * @param weight
	 *            weight in kilograms
	 */
	public BMICalculator(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	/**
	 * Get the BMI with as string with
	 */
	protected String getBMIAsString() {
		double bmi = calculateBMI();
		return new DecimalFormat("###.#").format(bmi);
	}

	/**
	 * Return the BMI Category.
	 */
	public int getBMICategory() {
		double bmi = calculateBMI();
		if (bmi < 18.5)
			return UNDERWEIGHT;
		if (bmi < 25)
			return NORMAL_WEIGHT;
		if (bmi < 30)
			return OVERWEIGHT;
		return OBESITY;
	}

	/**
	 * Return the BMI Category by age.
	 */
	public int getBMICategory(int age) {
		double bmi = calculateBMI();
		double ageOffset;

		if (age < 25) {
			ageOffset = 0;
		} else if (age < 35) {
			ageOffset = 1;
		} else if (age < 45) {
			ageOffset = 2;
		} else if (age < 55) {
			ageOffset = 3;
		} else if (age < 65) {
			ageOffset = 4;
		} else {
			ageOffset = 5;
		}

		if (bmi < 19 + ageOffset)
			return UNDERWEIGHT;
		if (bmi < 25 + ageOffset)
			return NORMAL_WEIGHT;
		if (bmi < 30 + ageOffset)
			return OVERWEIGHT;
		return OBESITY;
	}

	protected double calculateBMI() {
		return weight / Math.pow(Double.valueOf(height) / 100, 2);
	}

}
