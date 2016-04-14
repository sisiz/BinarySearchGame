package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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

	private JButton Ready;
	
	private JButton reset;
	private JLabel lblGuessNum;
	private JLabel lblMyGuess;
	private JLabel instructions;
	private JLabel guessCounter;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private JPanel panel_main;
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	
	private int[] data;
	private ArrayList<JLabel> numberLine;
	private ArrayList<String> Heroes;

	private JLabel sidekick;
	private JLabel sidekick_label;
	private JLabel sidekick_text;
	
	
	/*
	Take a int of current guess, a boolean of the hign/low status and an arraylist of labels and highghts the labels of the numbers
	that are no longer in consideration.
	*/
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		Heroes = new ArrayList<String>();
		Heroes.add("aang");
		Heroes.add("actual_deadpool");
		Heroes.add("astronaut");
		Heroes.add("batman");
		Heroes.add("bithsbee_normal");
		Heroes.add("capt_america");
		Heroes.add("deadpool");
		Heroes.add("ghost_rider");
		Heroes.add("hellboy");
		Heroes.add("hulk");
		Heroes.add("ironman");
		Heroes.add("recycle");
		Heroes.add("spiderman");
		Heroes.add("super_woman");
		Heroes.add("superman");
		Heroes.add("the_thing");
		Heroes.add("thor");
		Heroes.add("torch");
		Heroes.add("wolverine");
		Heroes.add("wonderwoman");
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<numberLine.size() ; i++){
				Icon im = new ImageIcon("src/"+Heroes.get(i)+"_x.png");

				((JLabel) numberLine.get(i)).setIcon(im);
				//((JComponent)numberLine.get(i)).setForeground(Color.RED);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				Icon im = new ImageIcon("src/"+Heroes.get(i)+"_x.png");
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
		Heroes = new ArrayList<String>();
		Heroes.add("aang");
		Heroes.add("actual_deadpool");
		Heroes.add("astronaut");
		Heroes.add("batman");
		Heroes.add("bithsbee_normal");
		Heroes.add("capt_america");
		Heroes.add("deadpool");
		Heroes.add("ghost_rider");
		Heroes.add("hellboy");
		Heroes.add("hulk");
		Heroes.add("ironman");
		Heroes.add("recycle");
		Heroes.add("spiderman");
		Heroes.add("super_woman");
		Heroes.add("superman");
		Heroes.add("the_thing");
		Heroes.add("thor");
		Heroes.add("torch");
		Heroes.add("wolverine");
		Heroes.add("wonderwoman");
		for (int i = 0; i<numberLine.size(); i++) {
			Icon im = new ImageIcon("src/" + Heroes.get(i)+".png");
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
		
		//Color my_Color = new Color(202,255,252);
		Color my_Color = Color.WHITE;
		
		setLayout(null);
		setBackground( my_Color );

		
		panel_main = new JPanel();
		panel_main.setBackground(my_Color);
		add(panel_main);
		panel_main.setBounds(0,0,1400,400);
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.PAGE_AXIS));

		
		//
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setBackground(Color.WHITE);

		
		found = false;
		guessCount = 0;
		
		panel_0 = new JPanel();
		panel_0.setBackground(my_Color);
		panel_main.add(panel_0);
		instructions = new JLabel("<html>Pick one of these superheroes."
				+ "<br> The computer will try to guess which superhero you chose."
				+ "<br> You will tell the computer 'too far to the left', 'too far to the right' or 'correct.'</html>");
		panel_0.add(instructions);

		
		
		
		panel_1 = new JPanel();
		panel_main.add(panel_1);
		panel_1.setBackground(my_Color);
		
		
		//different heroes
		Heroes = new ArrayList<String>();
		Heroes.add("aang");
		Heroes.add("actual_deadpool");
		Heroes.add("astronaut");
		Heroes.add("batman");
		Heroes.add("bithsbee_normal");
		Heroes.add("capt_america");
		Heroes.add("deadpool");
		Heroes.add("ghost_rider");
		Heroes.add("hellboy");
		Heroes.add("hulk");
		Heroes.add("ironman");
		Heroes.add("recycle");
		Heroes.add("spiderman");
		Heroes.add("super_woman");
		Heroes.add("superman");
		Heroes.add("the_thing");
		Heroes.add("thor");
		Heroes.add("torch");
		Heroes.add("wolverine");
		Heroes.add("wonderwoman");
		
		//creating number line
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		int x = Heroes.size();
		data = new int[x];
		numberLine = new ArrayList<JLabel>();
		
		for(int i = 0; i<x; i++)
		{	
			data[i] = i;
			JLabel lblNew = new JLabel();
			ImageIcon bisthbee = new ImageIcon("src/"+Heroes.get(i)+".png");
			//sets the image icon onto the binarysearchintro label
			lblNew.setIcon(bisthbee);
			//adds the binarysearchintro label & image to panel_binarysearchintro

			panel_1.add(lblNew);
			numberLine.add(lblNew);
		}
		
		panel_2 = new JPanel();
		panel_2.setBackground(my_Color);
		panel_main.add(panel_2);
		guessCounter = new JLabel("Chose one of these superheroes in your head" );
		//guessCounter = new JLabel("Here is my first guess " );
		Font f = new Font("ariel", Font.PLAIN, 20);
		guessCounter.setFont(f);
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
		//ImageIcon bisthbee = new ImageIcon("src/"+Heroes.get(guess)+"_g.png");
		//numberLine.get(guess).setIcon(bisthbee);
		
		//panel for buttons
		panel_3 = new JPanel();
		add(panel_3);
		panel_3.setBackground(my_Color);
		panel_3.setBounds(400,450,500,70);


		
		//button for guess too far to the left
		btnNewButton_1 = new JButton("Too far to the left!");
		//panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(found == false){
					if (low <= high-1){
						if (guess == high){
							JOptionPane.showMessageDialog(null,"I guessed the rightmost value of the range, this guess can't be too far left" );		
						}else{
							highlight(guess, false, numberLine);
							binaryGuess(data, -1);
							
							guessCount += 1;
							guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
							
							//ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png"); //diff pic
							//sidekick.setIcon(winner);

							//JOptionPane.showMessageDialog(null,"How about this guess."+ guess);
							//lblGuessNum.setText(Integer.toString(guess));
							//lblGuessNum.setText("How about this guess:" + guess);
							ImageIcon bisthbee = new ImageIcon("src/"+Heroes.get(guess)+"_g.png");
							numberLine.get(guess).setIcon(bisthbee);
						}
					}
					else{
						Icon im = new ImageIcon("src/"+Heroes.get(guess)+"_o.png");
						((JLabel) numberLine.get(guess)).setIcon(im);
						found = true;
						
						ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png");
						sidekick.setIcon(winner);

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
		//panel_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(found == false){
					Icon im = new ImageIcon("src/"+Heroes.get(guess)+"_o.png");
					((JLabel) numberLine.get(guess)).setIcon(im);
					
					guessCount += 1;
					guessCounter.setText("It took me " + Integer.toString(guessCount) + " total guesses " );
					found = true;
					ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png");
					sidekick.setIcon(winner);

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
		//panel_3.add(btnNewButton);
		//Pass the "too high" info to binaryGuess and update the display
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(found == false){
					if (low <= high-1){
						if (guess == low){
							JOptionPane.showMessageDialog(null,"I guessed the leftmost value of the range, this guess can't be too far right" );		
						}
						else{
							highlight(guess, true, numberLine);
							binaryGuess(data, 1);
							
							guessCount += 1;
							guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times, now " );
							
							//JOptionPane.showMessageDialog(null,"How about this guess." + guess);
							//lblGuessNum.setText(Integer.toString(guess));
							//lblGuessNum.setText("How about this guess:" + guess);
							
							//ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png");//change to diff pic?
							//sidekick.setIcon(winner);

							ImageIcon hero1 = new ImageIcon("src/"+Heroes.get(guess)+"_g.png");
							//ImageIcon hero1 = new ImageIcon("src/batman_g.png");
							numberLine.get(guess).setIcon(hero1);
							repaint();

						}
					}
					else{
						found = true;
						Icon im = new ImageIcon("src/"+Heroes.get(guess)+"_o.png");
						((JLabel) numberLine.get(guess)).setIcon(im);
						ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png");
						sidekick.setIcon(winner);
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
		
		//to have a start thing before game begins
		Ready = new JButton("Ready!");
		Ready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.remove(Ready);
				panel_3.add(btnNewButton_1);
				panel_3.add(btnNewButton_2);
				panel_3.add(btnNewButton);
				ImageIcon bisthbee = new ImageIcon("src/"+Heroes.get(guess)+"_g.png");
				numberLine.get(guess).setIcon(bisthbee);
				
				ImageIcon first_guess = new ImageIcon("src/Sidekick-Is-this-your-super-hero.png");
				sidekick.setIcon(first_guess);

				
				guessCounter.setText("I have guesses "+guessCount+" times");
				panel_3.revalidate();
				panel_3.repaint();
				repaint();

			}
		});
		panel_3.add(Ready);
		Ready.setPreferredSize(new Dimension(300,60));
		Font f5 = new Font("ariel", Font.PLAIN, 25);
		Ready.setFont(f5);


		
		
		panel_4 = new JPanel();
		add(panel_4);
		panel_4.setBackground(my_Color);
		panel_4.setBounds(600,550,200,100);

		reset = new JButton("Reset");
		panel_4.add(reset);
		
		//When clicked, reset the game by dehighlighting the labels and reinitialize other parameters
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
		}	
		});	
		
		
		//panel with sidekisck
		
		panel_5 = new JPanel();
		sidekick = new JLabel();
		ImageIcon start_sidekick = new ImageIcon("src/Sidekick-I-guess-in-the-middle.png");
		sidekick.setIcon(start_sidekick);
		panel_5.add(sidekick);
		add(panel_5);
		panel_5.setBackground(my_Color);
		panel_5.setBounds(900,400,500,400);

		
		
	}
		
	
	public void reset(){
		dehighlight(numberLine);
		found = false;
		low = 0;
		high = data.length - 1;
		guess = (low+high)/2;
		//ImageIcon bisthbee = new ImageIcon("src/"+Heroes.get(guess)+"_g.png");
		//numberLine.get(guess).setIcon(bisthbee);
		//lblMyGuess.setText("MyGuess:");
		//lblGuessNum.setText(Integer.toString(guess));
		ImageIcon start_sidekick = new ImageIcon("src/Sidekick-I-guess-in-the-middle.png");
		sidekick.setIcon(start_sidekick);

		panel_3.add(Ready);
		panel_3.remove(btnNewButton_1);
		panel_3.remove(btnNewButton_2);
		panel_3.remove(btnNewButton);
		//guessCounter.setText("I have guesses "+guessCount+" times");
		guessCounter.setText("Chose one of these superheroes in your head");
		panel_3.revalidate();
		panel_3.repaint();
		repaint();
		panel_2.repaint();

		guessCount = 0;
		//guessCounter.setText("I have guessed " + Integer.toString(guessCount) + " times  ");
		repaint();
	}
	
}
