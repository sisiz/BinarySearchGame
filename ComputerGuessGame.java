package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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



public class ComputerGuessGame extends JPanel{
	
	private static final long serialVersionUID = 1L;

	
	public int guess;
	public int low;
	public int high;
	
	private JButton reset;
	private JLabel lblGuessNum;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private JPanel panel;
	private JPanel panel_2;
	
	public static void highlight(int guess, boolean lowHigh, ArrayList labels){
		//True = too high, False = too low
		if (lowHigh){ //same as is lowHigh == True
			for (int i = guess; i<labels.size() ; i++){
				((JComponent)labels.get(i)).setForeground(Color.RED);
			}	 
		}
		else{
			for (int i = 0; i<=guess ; i++){
				((JComponent)labels.get(i)).setForeground(Color.RED);
			}
		}
	
	}
	
	public void dehighlight(ArrayList numberLine) {
		for (int i = 0; i<numberLine.size(); i++) {
			((JComponent)numberLine.get(i)).setForeground(Color.BLACK);
		}
	}
	
	
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
	
	
	public ComputerGuessGame() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		JLabel lblMyGuess = new JLabel("My Guess:");
		panel_1.add(lblMyGuess);
		
		lblGuessNum = new JLabel("");
		panel_1.add(lblGuessNum);
		
		
		//creating number line
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		int x = 20;
		final int[] data = new int[x];
		final ArrayList<JLabel> numberLine = new ArrayList<JLabel>();
		
		for(int i = 0; i<x; i++)
		{
			data[i] = i;
			JLabel lblNew = new JLabel((i)+", " );
			panel_2.add(lblNew);
			numberLine.add(lblNew);

		}
		
		//setting initial values for variables
        low = 0;
        high = data.length - 1;
		guess =(low+high)/2; 
		lblGuessNum.setText(Integer.toString(guess));
		
		
		//button for guess too low
		btnNewButton_1 = new JButton("Too Low!");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				highlight(guess, false, numberLine);
				binaryGuess(data, -1);
				
				JOptionPane.showMessageDialog(null,"How about this guess.");
				lblGuessNum.setText(Integer.toString(guess));
			}
		});
		
		//button for correct guess
		btnNewButton_2 = new JButton("Correct");
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Your number is guessed correctly. Mind read successful.");
				((JComponent)numberLine.get(guess)).setForeground(Color.GREEN);
				
								
			}
		});
		
		//button for guess too high
		btnNewButton = new JButton("Too High!");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highlight(guess, true, numberLine);
				binaryGuess(data, 1);
				JOptionPane.showMessageDialog(null,"How about this guess.");
				lblGuessNum.setText(Integer.toString(guess));
			}
		});
		
		JPanel panel1 = new JPanel();
		add(panel1, BorderLayout.SOUTH);
		reset = new JButton("Reset");
		panel1.add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dehighlight(numberLine);
		}
		});
		
		
	}
		
	
	
}

