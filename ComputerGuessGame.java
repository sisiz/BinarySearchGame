package example1;

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
	private boolean found;
	
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
	
	private int[] data;
	private ArrayList<JLabel> numberLine;
	private ArrayList<String> Heroes;

	
	
	/*
	Take a int of current guess, a boolean of the hign/low status and an arraylist of labels and highghts the labels of the numbers
	that are no longer in consideration.
	*/
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		
		Icon im = new ImageIcon("src/bisthbee_x.png");
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
		Icon im = new ImageIcon("src/bisthbee.png");
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
		
		//setLayout(null);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setBackground(Color.WHITE);

		
		found = false;
		guessCount = 0;
		
		panel_0 = new JPanel();
		add(panel_0);
		instructions = new JLabel("<html>Pick one of these superheroes."
				+ "<br> The computer will try to guess which superhero you chose."
				+ "<br> You will tell the computer 'too far to the left', 'too far to the right' or 'correct.'</html>");
		panel_0.add(instructions);

		
		panel_1 = new JPanel();
		add(panel_1);
		
		
		//different heroes
		Heroes = new ArrayList<String>();
		Heroes.add("aang.png");
		Heroes.add("actual_deadpool.png");
		Heroes.add("astronaut.png");
		Heroes.add("batman.png");
		Heroes.add("bisthbee.png");
		Heroes.add("capt_america.png");
		Heroes.add("deadpool.png");
		Heroes.add("ghost_rider.png");
		Heroes.add("hellboy.png");
		Heroes.add("hulk.png");
		Heroes.add("ironman.png");
		Heroes.add("recycle.png");
		Heroes.add("spiderman.png");
		Heroes.add("super_woman.png");
		Heroes.add("superman.png");
		Heroes.add("the_thing.png");
		Heroes.add("thor.png");
		Heroes.add("torch.png");
		Heroes.add("wolverine.png");
		Heroes.add("wonderwman.png");
		
		
		//creating number line
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		int x = 20;
		data = new int[x];
		numberLine = new ArrayList<JLabel>();
		
		for(int i = 0; i<x; i++)
		{	
			data[i] = i;
			JLabel lblNew = new JLabel();
			ImageIcon bisthbee = new ImageIcon("src/bisthbee.png");
			//sets the image icon onto the binarysearchintro label
			lblNew.setIcon(bisthbee);
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
		ImageIcon bisthbee = new ImageIcon("src/bisthbee_g.png");
		numberLine.get(guess).setIcon(bisthbee);
		
		//panel for buttons
		panel_3 = new JPanel();
		add(panel_3);

		//button for guess too far to the left
		btnNewButton_1 = new JButton("Too far to the left!");
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(found == false){
					if (low <= high-1){
					
						highlight(guess, false, numberLine);
						binaryGuess(data, -1);
						
						guessCount += 1;
						guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
						
						//JOptionPane.showMessageDialog(null,"How about this guess."+ guess);
						//lblGuessNum.setText(Integer.toString(guess));
						//lblGuessNum.setText("How about this guess:" + guess);
						ImageIcon bisthbee = new ImageIcon("src/bisthbee_g.png");
						numberLine.get(guess).setIcon(bisthbee);
					}
					else{
						Icon im = new ImageIcon("src/bisthbee_o.png");
						((JLabel) numberLine.get(guess)).setIcon(im);
						found = true;
						guessCount += 1;
						guessCounter.setText("It took me " + Integer.toString(guessCount) + " total guesses " );
						JOptionPane.showMessageDialog(null,"I have  found the superhero! \n You can restart the game by clicking on the reset button" );	

					}
				}
				else{
					JOptionPane.showMessageDialog(null,"You have already found the superhero! \n You can restart the game by clicking on the reset button" );	
				}
			}
		});
		
		//button for correct guess
		btnNewButton_2 = new JButton("Correct");
		panel_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(found == false){
					Icon im = new ImageIcon("src/bisthbee_o.png");
					((JLabel) numberLine.get(guess)).setIcon(im);
					
					guessCount += 1;
					guessCounter.setText("It took me " + Integer.toString(guessCount) + " total guesses " );
					found = true;
					//((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
					//JOptionPane.showMessageDialog(null,"Your number is guessed correctly. Mind read successful.");
					//lblMyGuess.setText("Your number is guessed correctly. Mind read successful.");
					///lblGuessNum.setText("your number is: " + guess);
				}
				else{
					JOptionPane.showMessageDialog(null,"You have already found the superhero! \n You can restart the game by clicking on the reset button" );	 
				}
			}
		});
		
		//button for guess too far to the right
		btnNewButton = new JButton("Too far to the right!");
		panel_3.add(btnNewButton);
		//Pass the "too high" info to binaryGuess and update the display
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(found == false){
					if (low <= high-1){

						highlight(guess, true, numberLine);
						binaryGuess(data, 1);
						
						guessCount += 1;
						guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
						
						//JOptionPane.showMessageDialog(null,"How about this guess." + guess);
						//lblGuessNum.setText(Integer.toString(guess));
						//lblGuessNum.setText("How about this guess:" + guess);
						ImageIcon bisthbee = new ImageIcon("src/bisthbee_g.png");
						numberLine.get(guess).setIcon(bisthbee);
					}
					else{
						found = true;
						Icon im = new ImageIcon("src/bisthbee_o.png");
						((JLabel) numberLine.get(guess)).setIcon(im);
						guessCount += 1;
						guessCounter.setText("It took me " + Integer.toString(guessCount) + " total guesses " );
						JOptionPane.showMessageDialog(null,"I have  found the superhero! \n You can restart the game by clicking on the reset button" );	

					}	
				}
				else{
					JOptionPane.showMessageDialog(null,"You have already found the superhero! \n You can restart the game by clicking on the reset button" );
				}
			}
		});
		
		panel_4 = new JPanel();
		add(panel_4);
		reset = new JButton("Reset");
		panel_4.add(reset);
		
		//When clicked, reset the game by dehighlighting the labels and reinitialize other parameters
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
		}	
		});	
		
	}
		
	
	public void reset(){
		dehighlight(numberLine);
		found = false;
		low = 0;
		high = data.length - 1;
		guess = (low+high)/2;
		ImageIcon bisthbee = new ImageIcon("src/bisthbee_g.png");
		numberLine.get(guess).setIcon(bisthbee);
		//lblMyGuess.setText("MyGuess:");
		//lblGuessNum.setText(Integer.toString(guess));
		guessCount = 0;
		guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times  ");
		repaint();
	}
	
}
