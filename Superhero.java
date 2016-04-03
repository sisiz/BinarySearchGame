package example1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Superhero extends JButton{

	final int strength;
	private String image;
	
	public Superhero( final int s, String image){
		
		this.strength = s;
		this.image = image;
		
		ImageIcon im = new ImageIcon(image);
		this.setIcon(im);
		
		/*
		this.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				KidsGuessGame.binary_search(s);
				
			}
		});
		*/			
		
	}
	
	public int getStength(){
		return strength;
	}
	
	public void setImage(String im){
		ImageIcon img = new ImageIcon(im);
		setIcon(img);

	}
	
	
}
