/**
 * This is exercise
 */
import javax.swing.JOptionPane;
public class DoubleNumbers {
	public static void main(String[] args){
		double num1 = Double.parseDouble(JOptionPane.showInputDialog("Please input the first number: "));
		double num2 = Double.parseDouble(JOptionPane.showInputDialog("Please input the second number: "));
		
		double sum = num1 + num2;
		double difference;
		
		if (num1 > num2) {
			difference = num1 - num2;
		} else {
			difference = num2 - num1;
		}

		double product = num1*num2;
		double quotient = num1/num2;

		JOptionPane.showMessageDialog(null, sum, "The sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, difference, "The difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, product, "The product of two numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, quotient, "The quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
	}
}