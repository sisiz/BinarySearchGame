//just testing is the repo is working

package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	private int guessCount;
	
	private JTextField textField_1;
	private JButton btnGuess;
	private JButton reset;
	private JLabel instructions;
	private JLabel instructions_2;
	private JLabel guessCounter;
	
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private ArrayList numberLine;

	
	public KidsGuessGame(){
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		guessCount = 0;
		
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
		numberLine = new ArrayList();
		for (int i = 0; i < 20; i++){
			final Superhero Superhero_1 = new Superhero( i, "src/batman.png" );
			Superhero_1.addActionListener(new ActionListener() {	
				public void actionPerformed(ActionEvent e) {
					binary_search( Superhero_1.getStength() );
				}
			});
			panel_1.add(Superhero_1);
			numberLine.add(Superhero_1);
		}
		
	
		
		//panel for user input (text box for guess, and button to guess)
		panel_2 = new JPanel();
		add(panel_2);
		
		/*
		//creates text field to input number to highlight from
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		*/
		
		//set initial variables
		chosenNum = (int)(Math.random()*numberLine.size());
		low = 0;
		high = numberLine.size() -1 ;
		
		/*
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
						binary_search(guess);
						
					}
						
				}catch (Exception e1) {
					//create a pop up that says input not an integer
					JOptionPane.showMessageDialog(null,"you need to input a integer");
					textField_1.setText("");
				}	
				
			}
		});
		*/
		
		instructions_2 = new JLabel("");
		panel_2.add(instructions_2);
		
		//panel for restart button
		panel_3 = new JPanel();
		guessCounter = new JLabel();
		guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");
		add(panel_3);
		panel_3.add(guessCounter);

		reset = new JButton("Reset");
		panel_3.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dehighlight(numberLine);
				chosenNum = (int)(Math.random()*numberLine.size());
				low = 0;
				high = numberLine.size() -1 ;	
				guessCount = 0;
				guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");
				repaint();
		}
		});
	
	}

	
	public void binary_search(int guess){
		guessCount += 1;
		guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");
		
		if((guess<low) || (guess> high)){
			instructions_2.setText("this number has been removed from the range");
			//JOptionPane.showMessageDialog(null,"this number has been removed from the range");
			//textField_1.setText("");
		}
		else if (guess == chosenNum){
			//((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
			//add something later about playing again
			Icon im = new ImageIcon("src/batman_o.png");
			((Superhero) numberLine.get(guess)).setIcon(im);
			JOptionPane.showMessageDialog(null,"Good job you guessed the number in " + Integer.toString(guessCount)+ " guesses!" );



		}
		//child's guess less than the number the computer chose
		else if (guess < chosenNum && guess>=low){
			highlight(guess,false, numberLine);
			low = guess;
			instructions_2.setText("<html>The red numbers have been removed from the range"
					+ "<br>Guess a number that is still black</html>");
			
		}
		//child's guess is greater than the number the computer chose
		else if (guess > chosenNum && guess<=high){
			highlight(guess,true, numberLine);
			high = guess;
			instructions_2.setText("<html>The red numbers have been removed from the range"
					+ "<br>Guess a number that is still black</html>");
		}
		
	}
	
	
	//hilights number line, either all numbers below of above guess
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		
		Icon im = new ImageIcon("src/batman_x.png");
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<numberLine.size() ; i++){
				((Superhero) numberLine.get(i)).setIcon(im);
				//((JComponent)numberLine.get(i)).setForeground(Color.RED);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				//((JComponent)numberLine.get(i)).setForeground(Color.RED);
				((Superhero) numberLine.get(i)).setIcon(im);

			}
		}
		repaint();
	}
	
	
	//sets numberline back to black
	public void dehighlight(ArrayList numberLine) {
		Icon im = new ImageIcon("src/batman.png");
		for (int i = 0; i<numberLine.size(); i++) {
			//set everything back to BATMAN
			//((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
			//Icon im = new ImageIcon("src/batman.png");
			((Superhero) numberLine.get(i)).setIcon(im);

		}
	}
	
	
	
}

