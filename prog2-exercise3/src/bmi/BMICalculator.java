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
		double bmi = 0;
		// start coding here
		
		// end coding her
		return new DecimalFormat("###.#").format(bmi);
	}	
	
	/**
	 * Return the BMI Category.
	 */
	public int getBMICategory() {
		double bmi = Double.valueOf(getBMIAsString());
		if (bmi < 18.5)
			return UNDERWEIGHT;
		if (bmi < 25)
			return NORMAL_WEIGHT;
		if (bmi < 30)
			return OVERWEIGHT;
		return OBESITY;
	}
}
