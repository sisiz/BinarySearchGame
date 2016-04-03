package example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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



public class ComputerGuessGame extends JPanel{
	
	private static final long serialVersionUID = 1L;

	
	public int guess;
	public int low;
	public int high;
	private int guessCount;
	
	private JButton reset;
	private JLabel lblGuessNum;
	private JLabel lblMyGuess;
	private JLabel instructions;
	private JLabel guessCounter;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	/*
	Take a int of current guess, a boolean of the hign/low status and an arraylist of labels and highghts the labels of the numbers
	that are no longer in consideration.
	*/
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		
		Icon im = new ImageIcon("src/batman_x.png");
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<numberLine.size() ; i++){
				((JLabel) numberLine.get(i)).setIcon(im);
				//((JComponent)numberLine.get(i)).setForeground(Color.RED);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				//((JComponent)numberLine.get(i)).setForeground(Color.RED);
				((JLabel) numberLine.get(i)).setIcon(im);

			}
		}
		repaint();
	}

	/*
	Dehighlight all the labels in the given arraylist
	*/
	public void dehighlight(ArrayList numberLine) {
		Icon im = new ImageIcon("src/batman.png");
		for (int i = 0; i<numberLine.size(); i++) {
			//((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
			((JLabel) numberLine.get(i)).setIcon(im);

		}
	}
	
	/*
	Updates the guess of the number in the given list based on the user feedback as input
	*/
	public void binaryGuess(int[] data, int input) 
    {
		
        if(high >= low) {
             if(input == -1) {
                 low = guess + 1;
             }
             if(input == 1) {
                 high = guess - 1;
             }
             guess = (low + high) / 2;
        }
        return ;
   }
	
	/*
	Constructor of the game instance.
	*/
	public ComputerGuessGame() {
		
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		guessCount = 0;
		
		panel_0 = new JPanel();
		add(panel_0);
		instructions = new JLabel("<html>Pick one of these superheroes."
				+ "<br> The computer will try to guess which superhero you chose."
				+ "<br> You will tell the computer 'too far to the left', 'too far to the right' or 'correct.'</html>");
		panel_0.add(instructions);

		
		panel_1 = new JPanel();
		add(panel_1);
		
		//creating number line
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		int x = 20;
		final int[] data = new int[x];
		final ArrayList<JLabel> numberLine = new ArrayList<JLabel>();
		
		for(int i = 0; i<x; i++)
		{
			
			data[i] = i;
			JLabel lblNew = new JLabel();
			ImageIcon batman = new ImageIcon("src/batman.png");
			//sets the image icon onto the binarysearchintro label
			lblNew.setIcon(batman);
			//adds the binarysearchintro label & image to panel_binarysearchintro

			
			panel_1.add(lblNew);
			numberLine.add(lblNew);
		}

		
		
		panel_2 = new JPanel();
		add(panel_2);
		guessCounter = new JLabel("Here is my first guess " );
		panel_2.add(guessCounter);
		
		//lblMyGuess = new JLabel("My Guess:");
		//panel_2.add(lblMyGuess);
		
		lblGuessNum = new JLabel("");
		panel_2.add(lblGuessNum);
		
		
		
		//setting initial values for variables
		low = 0;
		high = data.length - 1;
		guess =(low+high)/2; 
		//lblGuessNum.setText(Integer.toString(guess));
		ImageIcon batman = new ImageIcon("src/batman_g.png");
		numberLine.get(guess).setIcon(batman);

		
		//panel for buttons
		panel_3 = new JPanel();
		add(panel_3);

		//button for guess too far to the left
		btnNewButton_1 = new JButton("Too far to the left!");
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				highlight(guess, false, numberLine);
				binaryGuess(data, -1);
				
				guessCount += 1;
				guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
				
				//JOptionPane.showMessageDialog(null,"How about this guess."+ guess);
				//lblGuessNum.setText(Integer.toString(guess));
				//lblGuessNum.setText("How about this guess:" + guess);
				ImageIcon batman = new ImageIcon("src/batman_g.png");
				numberLine.get(guess).setIcon(batman);
				

			}
		});
		
		//button for correct guess
		btnNewButton_2 = new JButton("Correct");
		panel_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Icon im = new ImageIcon("src/batman_o.png");
				((JLabel) numberLine.get(guess)).setIcon(im);
				
				guessCount += 1;
				guessCounter.setText("It took me " + Integer.toString(guessCount) + " total guesses " );
				
				//((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
				//JOptionPane.showMessageDialog(null,"Your number is guessed correctly. Mind read successful.");
				//lblMyGuess.setText("Your number is guessed correctly. Mind read successful.");
				///lblGuessNum.setText("your number is: " + guess);
			}
		});
		
		//button for guess too far to the right
		btnNewButton = new JButton("Too far to the right!");
		panel_3.add(btnNewButton);
		//Pass the "too high" info to binaryGuess and update the display
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highlight(guess, true, numberLine);
				binaryGuess(data, 1);
				
				guessCount += 1;
				guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
				
				//JOptionPane.showMessageDialog(null,"How about this guess." + guess);
				//lblGuessNum.setText(Integer.toString(guess));
				//lblGuessNum.setText("How about this guess:" + guess);
				ImageIcon batman = new ImageIcon("src/batman_g.png");
				numberLine.get(guess).setIcon(batman);

			}
		});
		
		panel_4 = new JPanel();
		add(panel_4);
		reset = new JButton("Reset");
		panel_4.add(reset);
		
		//When clicked, reset the game by dehighlighting the labels and reinitialize other parameters
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dehighlight(numberLine);
				low = 0;
        		high = data.length - 1;
        		guess = (low+high)/2;
        		//lblMyGuess.setText("MyGuess:");
				//lblGuessNum.setText(Integer.toString(guess));
				guessCount = 0;
				guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times  ");

				repaint();
		}	
		});	
		
	}
		
	
	
}
