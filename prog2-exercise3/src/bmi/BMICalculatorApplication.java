package bmi;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Application which shows a GUI to calculate the Body Mass Index (BMI).
 * 
 * @author meiglspe
 *
 */
public class BMICalculatorApplication {
	
	private JFrame frame;
	
	public BMICalculatorApplication() {
		frame = new JFrame();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(3,1));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,2));
		JLabel sizeLabel = new JLabel("Size (in centimeter)");
		final JTextField sizeInput = new JTextField();
		JLabel weightLabel = new JLabel("Weight (in kilograms");
		final JTextField weightInput = new JTextField();
		inputPanel.add(sizeLabel);
		inputPanel.add(sizeInput);
		inputPanel.add(weightLabel);
		inputPanel.add(weightInput);
		contentPane.add(inputPanel);
		
		JButton calculate = new JButton("Calculate");
		contentPane.add(calculate);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new GridLayout(2,2));
		JLabel bmiLabel = new JLabel("Body Mass Index (BMI):");
		JLabel bmi = new JLabel();
		JLabel categoryLabel = new JLabel("Category:");
		JLabel category = new JLabel();
		outputPanel.add(bmiLabel);
		outputPanel.add(bmi);
		outputPanel.add(categoryLabel);
		outputPanel.add(category);
		contentPane.add(outputPanel);
		category.setBackground(Color.RED);
	
		calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String size = sizeInput.getText();
				String weight = weightInput.getText();
				
				int s = Integer.valueOf(size);
				int w = Integer.valueOf(weight);
				
				BMICalculator bmiCalculator = new BMICalculator(s, w);
				
				bmi.setText(""+bmiCalculator.getBMIAsString());		
				switch (bmiCalculator.getBMICategory()) {
					case BMICalculator.UNDERWEIGHT:
						category.setText("Underweight");
						category.setForeground(Color.RED);
						break;
					case BMICalculator.NORMAL_WEIGHT:
						category.setText("Normal Weight");
						category.setForeground(Color.GREEN);
						break;
					case BMICalculator.OVERWEIGHT:
						category.setText("Overweight");
						category.setForeground(Color.ORANGE);
						break;
					case BMICalculator.OBESITY:
						category.setText("Obesity");
						category.setForeground(Color.RED);
						break;
				}
			}
		});
	
		frame.addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		BMICalculatorApplication application = new BMICalculatorApplication();
	}
}
