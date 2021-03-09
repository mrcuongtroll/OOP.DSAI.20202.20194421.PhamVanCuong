/**
 *This is the exercise 2.2.6
 *
 */
import javax.swing.JOptionPane;

public class EqSolver {
	public static void main(String[] args) {
		String[] options = {"Linear equation with one variable",
		 "System of linear equations with two variables", 
		 "Second-degree equation with one variable"};
		String userChoice = (String)JOptionPane.showInputDialog(null, "What kind of problem do you want to solve?",
		 "Select problem", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


	}
}