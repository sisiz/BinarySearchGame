package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	private boolean found;
	
	private JTextField textField_1;
	private JButton btnGuess;
	private JButton reset;
	private JLabel instructions;
	private JLabel instructions_2;
	private JLabel guessCounter;
	
	private JPanel panel_main;
	
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	private JLabel sidekick;
	
	private ArrayList numberLine;

	
	public KidsGuessGame(){
		
		//Color my_Color = new Color(202,255,252);
		Color my_Color = Color.WHITE;
		Font f = new Font("ariel", Font.PLAIN, 20);
		
		setBackground(my_Color);
		setLayout(null);
		
		panel_main = new JPanel();
		add(panel_main);
		panel_main.setBackground(my_Color);
		panel_main.setBounds(0,0,1400,300);
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.PAGE_AXIS));
		
		
		guessCount = 0;
		found = false;
		
		//panel with sidekisck
		Image img4 = null;
	    try {
	    	img4 = ImageIO.read(new File("src/supersidekick_2.png"));}
	    catch (IOException e){	
	    	e.printStackTrace();
	    }
	    
		//panel_4 = new BackgroundPanel(img4,2);
		panel_4 = new JPanel();
	    add(panel_4);
		panel_4.setBackground(my_Color);
		panel_4.setBounds(800,300,600,400);
		sidekick = new JLabel();
		ImageIcon start = new ImageIcon("src/Sidekick-kidsguess-check-if-clone.png");
		sidekick.setIcon(start);
		panel_4.add(sidekick);
		
		//sidekick_text.setBounds(0, 0, 50, 50);
		//sidekick_text = new JLabel("Hello");
		//sidekick_text.setFont(sidekick_text.getFont().deriveFont(Font.BOLD, 48));
		//sidekick_text.setForeground(Color.WHITE);
		//sidekick_text.setHorizontalAlignment(JLabel.CENTER);
		//panel_4.add(sidekick_text);
		
		
		
		//panel with instructions
		panel_0 = new JPanel();
		panel_main.add(panel_0);
		panel_0.setBackground(my_Color);
		/*instructions = new JLabel("<html>The computer has chosen a superhero."
				+ "<br> Guess which one the computer chose:<</html>");
		panel_0.add(instructions);*/
		instructions = new JLabel("<html><br><br><br><br><br></html>");
		panel_0.add(instructions);

		
		
		//panel for number line
		panel_1 = new JPanel();
		panel_main.add(panel_1);
		panel_1.setBackground(my_Color);
		//create a list of labels
		numberLine = new ArrayList();
		for (int i = 0; i < 20; i++){
			final Superhero Superhero_1 = new Superhero( i, "src/bisthbee.png" );
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
		panel_main.add(panel_2);
		panel_2.setBackground(my_Color);

		
		//set initial variables
		chosenNum = (int)(Math.random()*numberLine.size());
		low = 0;
		high = numberLine.size() -1 ;
		
		instructions_2 = new JLabel("");
		panel_2.add(instructions_2);
		
		//panel for restart button
		panel_3 = new JPanel();
		guessCounter = new JLabel();
		guessCounter.setFont(f);
		guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");
		add(panel_3);
		panel_3.setBackground(my_Color);
		panel_3.setBounds(500,450,300,80);
		panel_3.add(guessCounter);

		
		reset = new JButton("Reset");
		panel_3.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
		}
		});
	
	}

	public void reset(){
		dehighlight(numberLine);
		found = false;
		chosenNum = (int)(Math.random()*numberLine.size());
		low = -1;
		high = numberLine.size()  ;	
		guessCount = 0;
		guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");
		
		ImageIcon start = new ImageIcon("src/Sidekick-kidsguess-check-if-clone.png");
		sidekick.setIcon(start);
		instructions_2.setText("");
		repaint();
	}
	
	
	public void binary_search(int guess){
		if(found == false){
			//guessCount += 1;
			
			if((guess<=low) || (guess>= high)){
				instructions_2.setText("this superhero has been removed from the range");
				//JOptionPane.showMessageDialog(null,"this number has been removed from the range");
				//textField_1.setText("");
				//guessCount -= 1;
				repaint();
			}
			else if (guess == chosenNum){
				guessCount += 1;
				//((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
				//add something later about playing again
				Icon im = new ImageIcon("src/bisthbee_o.png");
				found = true;

				ImageIcon winner = new ImageIcon("src/Sidekick-yay-winner.png");
				sidekick.setIcon(winner);

				((Superhero) numberLine.get(guess)).setIcon(im);
				JOptionPane.showMessageDialog(null,"Good job you found the superhero in " + Integer.toString(guessCount)+ " guesses!" );
	
			}
			//child's guess less than the number the computer chose
			else if (guess < chosenNum && guess>low){
				guessCount += 1;
				highlight(guess,false, numberLine);
				low = guess;

				ImageIcon left = new ImageIcon("src/Sidekick-Oops-the-left-ones-are-clones.png");
				sidekick.setIcon(left);
				
				instructions_2.setText("<html>The crossed out superheroes have been removed from the range"
						+ "<br>Guess a superhero that is not crossed out</html>");
				
			}
			//child's guess is greater than the number the computer chose
			else if (guess > chosenNum && guess<high){
				guessCount += 1;
				highlight(guess,true, numberLine);
				high = guess;
				
				ImageIcon right = new ImageIcon("src/Sidekick-clones-to-the-right.png");
				sidekick.setIcon(right);

				instructions_2.setText("<html>The crossed out superheroes have been removed from the range"
						+ "<br>Guess a superhero that is not crossed out</html>");
			}
			guessCounter.setText("You have guessed " + Integer.toString(guessCount) + " times  ");

		}
		else{
			JOptionPane.showMessageDialog(null,"You have already found the superhero! \n You can restart the game by clicking on the reset button" );
		}
		
		
	}
	
	
	//hilights number line, either all numbers below of above guess
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		
		Icon im = new ImageIcon("src/bisthbee_x.png");
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
		Icon im = new ImageIcon("src/bisthbee.png");
		for (int i = 0; i<numberLine.size(); i++) {
			//set everything back to BATMAN
			//((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
			//Icon im = new ImageIcon("src/batman.png");
			((Superhero) numberLine.get(i)).setIcon(im);

		}
	}
	
	
	
}
