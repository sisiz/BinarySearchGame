package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int high = 19;
	private int low = 0;
	
	private JTextField textField_1;
	private JButton btnColorChange;
	private JButton reset;

	
	
	public KidsGuessGame(){
		//create a list of labels
		final ArrayList numberLine = new ArrayList();
		for (int i = 0; i < 20; i++){
			lblNewLabel_1 = new JLabel((i)+", " );
			add(lblNewLabel_1);
			numberLine.add(lblNewLabel_1);
		}
		
		//creates text field to input number to highlight from
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
				
	
		//changed from final int to int
		int chosenNum = (int)(Math.random()*numberLine.size());
		
		btnColorChange = new JButton("Guess");
		btnColorChange.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//get text field input
				String s = textField_1.getText();
				int guess = 0;
				
				//try to make sure it is actually a number
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
					
					//valid input number, 
					else{
						if (guess == chosenNum){
							JOptionPane.showMessageDialog(null,"Good job you guessed the number");
							((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
							//attempt to make the reset button appear after winning the game
								//resetbutton(numberLine);
							//add something later about playing again	
						}
						else if (guess < chosenNum && guess>=low){
							highlight(guess,false, numberLine);
							low = guess;
						}
						else if (guess > chosenNum && guess<=high){
							highlight(guess,true, numberLine);
							high = guess;
						}
						
					}
						
				}catch (Exception e1) {
					//e1.printStackTrace();
					//create a pop up that says not an integer
					JOptionPane.showMessageDialog(null,"you need to input a integer");
					textField_1.setText("");
				}	
				
			}
		});
		add(btnColorChange);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		reset = new JButton("Reset");
		panel.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dehighlight(numberLine);
		}
		});
	
	}

	
	
	public void highlight(int guess, boolean lowHigh, ArrayList numberLine){
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<numberLine.size() ; i++){
				((JComponent)numberLine.get(i)).setForeground(Color.CYAN);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				((JComponent)numberLine.get(i)).setForeground(Color.CYAN);
			}
		}
	}
	
	public void dehighlight(ArrayList numberLine) {
		for (int i = 0; i<numberLine.size(); i++) {
			((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
			int newchosenNum = (int)(Math.random()*numberLine.size());
			int chosenNum = newchosenNum;
			// attempt at resetting number final int chosenNum = (int)(Math.random()*numberLine.size());
		}
	}
	
	public void randomnumber(ArrayList numberLine) {
		int newnumber1 = (int)(Math.random()*numberLine.size()); 
		int newnumber2 = (int)(Math.random()*numberLine.size()); 
		JOptionPane.showMessageDialog(null,newnumber1);
		JOptionPane.showMessageDialog(null,newnumber2);
	}
	
	/* function attempt to reset button after winning game
	public void resetbutton(ArrayList numberLine){
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		reset = new JButton("Reset");
		panel.add(reset);
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dehighlight(numberLine);
			}
			});
	}
	
	*/
	
	
	
}






