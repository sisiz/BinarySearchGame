//just testing is the repo is working

package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class KidsGuessGame extends JPanel{

	JLabel lblNewLabel_1;

	private static final long serialVersionUID = 1L;

	private int high;
	private int low;
	private int chosenNum;
	
	private JTextField textField_1;
	private JButton btnGuess;
	private JButton reset;
	private JLabel instructions;

	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	
	public KidsGuessGame(){
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//panel with instructions
		panel_0 = new JPanel();
		add(panel_0);
		instructions = new JLabel("<html>The computer has chosen a number."
				+ "<br> Enter your guess for what that number is:<</html>");
		panel_0.add(instructions);

		//panel for number line
		panel_1 = new JPanel();
		add(panel_1);
		//create a list of labels
		final ArrayList numberLine = new ArrayList();
		for (int i = 0; i < 20; i++){
			lblNewLabel_1 = new JLabel((i)+", " );
			panel_1.add(lblNewLabel_1);
			numberLine.add(lblNewLabel_1);
		}
		
		//panel for user input (text box for guess, and button to guess)
		panel_2 = new JPanel();
		add(panel_2);
		
		//creates text field to input number to highlight from
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		//set initial variables
		chosenNum = (int)(Math.random()*numberLine.size());
		low = 0;
		high = numberLine.size() -1 ;
		
		//button for user to make guess after inputing muber into text box
		btnGuess = new JButton("Guess");
		panel_2.add(btnGuess);
		btnGuess.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				
				//get text field input
				String s = textField_1.getText();
				int guess = 0;
				
				//make sure it is a valid guess
				try{
					guess = Integer.parseInt(s);
					//check if number in range
					if ((guess<0) || (guess> numberLine.size()-1)){
						JOptionPane.showMessageDialog(null,"number out of entire range");
						textField_1.setText("");
					}
					//out of range
					else if((guess<low) || (guess> high)){
						JOptionPane.showMessageDialog(null,"this number has been removed from the range");
						textField_1.setText("");
					}
					
					//valid input number:
					else{
						//child's guess is the number the computer chose
						if (guess == chosenNum){
							JOptionPane.showMessageDialog(null,"Good job you guessed the number");
							((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
							//add something later about playing again
						}
						//child's guess less than the number the computer chose
						else if (guess < chosenNum && guess>=low){
							highlight(guess,false, numberLine);
							low = guess;
						}
						//child's guess is grater than the number the computer chose
						else if (guess > chosenNum && guess<=high){
							highlight(guess,true, numberLine);
							high = guess;
						}
						
					}
						
				}catch (Exception e1) {
					//create a pop up that says input not an integer
					JOptionPane.showMessageDialog(null,"you need to input a integer");
					textField_1.setText("");
				}	
				
			}
		});
		
		//panel for restart button
		panel_3 = new JPanel();
		add(panel_3);
		reset = new JButton("Reset");
		panel_3.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dehighlight(numberLine);
				chosenNum = (int)(Math.random()*numberLine.size());
				low = 0;
				high = numberLine.size() -1 ;				
		}
		});
	
	}

	
	//hilights number line, either all numbers below of above guess
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<numberLine.size() ; i++){
				((JComponent)numberLine.get(i)).setForeground(Color.RED);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				((JComponent)numberLine.get(i)).setForeground(Color.RED);
			}
		}
	}
	
	
	//sets numberline back to black
	public void dehighlight(ArrayList numberLine) {
		for (int i = 0; i<numberLine.size(); i++) {
			((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
		}
	}
	
	
	
}

