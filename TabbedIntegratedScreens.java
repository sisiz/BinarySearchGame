package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabbedIntegratedScreens extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedIntegratedScreens frame = new TabbedIntegratedScreens();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private KidsGuessGame panel;
	private JTabbedPane tabbedPane;
	private ComputerGuessGame panel_1;
	private JPanel panel_imageholder;
	private JPanel panel_holding2buttons;
	private JPanel panel_KidsGuessModeIntro;
	private JButton btnTest;
	private JLabel imageholder;
	private JButton back;
	private JButton KidsGuessMode;
	
	private JSplitPane splitPane;
	
	private ImageIcon startscreen;
	private ImageIcon storyline1;
	private ImageIcon storyline2;
	private ImageIcon storyline3;
	private ImageIcon storyline4;		//not being used now
	
	private ImageIcon storyline2CPU;
	private ImageIcon storyline3CPU;
	private ImageIcon storyline4CPU;	//not being used now
	
	private JButton btnNewButton_1;
	private ImageIcon binarysearch;
	private JButton btnInstructions;
	private JButton btnNewButton;
	private JButton toKidsMode;
	private JButton toCPUMode;
	
	
	private JButton next1;
	private JButton next2;
	private JButton next3;		//not being used now
	private JButton next1CPU;
	private JButton next2CPU;
	private JButton next3CPU;	//not being used now
	
	
	public TabbedIntegratedScreens() {
		//initiates background template
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 15000, 800);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//creates tabbed buttons pane at the top of the screen
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		//creates Start Screen panel
		JPanel panel_0 = new JPanel(); 
		//createsStart Screen tab
		tabbedPane.addTab("Start Screen", null, panel_0, null); 
		//creates a BorderLayout for the Start Screen panel
		panel_0.setLayout(new BorderLayout(0, 0));
		
		//creates panel that holds the 2 buttons
		panel_holding2buttons = new JPanel();
		//splits the holding2buttons panel into 2 for the Kids Guess Mode button & the Computer Guess Mode button
		splitPane = new JSplitPane();
		//adds the holding2buttons panel to the center section of panel_0, the start screen panel
		panel_0.add(panel_holding2buttons, BorderLayout.CENTER);
		
		//adds the split panel to the holding2buttons panel
		panel_holding2buttons.add(splitPane);
		
		//creates button for Kids Guess Mode
		btnNewButton = new JButton("Kids Guess Mode");
		//puts button in left pane that was previously split
		splitPane.setLeftComponent(btnNewButton); 
		
		//creates button for Computer Guess Mode
		btnNewButton_1 = new JButton("Computer Guess Mode");
		//puts button in right pane that was previously split
		splitPane.setRightComponent(btnNewButton_1); 
		
		//creates button for Instructions
		btnInstructions = new JButton("What's Binary Search?");
		//adds the instructions button to the panel_holding2buttons
		panel_holding2buttons.add(btnInstructions);
		
		//creates Kids Guess Mode panel
		panel = new KidsGuessGame(); 
		//creates Kids Guess Mode tab
		tabbedPane.addTab("Kids Game", null, panel, null); 
		
		//creates Computer Guess Mode panel
		panel_1 = new ComputerGuessGame(); 
		//creates Computer Guess Mode tab
		tabbedPane.addTab("Computer Game", null, panel_1, null);
		
		//creates the panel holding the image
		JPanel panel_imageholder = new JPanel();
		//adds the panel holding the image to the north section of panel_0, the start screen panel
		panel_0.add(panel_imageholder, BorderLayout.NORTH);
		
		//creates label for the image holder
		imageholder = new JLabel();
		
		//creates an image icon for the binary search image
		startscreen = new ImageIcon("src/startscreen.png");
		
		//creates image icon for the binarysearch image]
		binarysearch = new ImageIcon("src/binarysearchstartscreen.png");
		
		//sets the image icon onto the imageholder label
		imageholder.setIcon(startscreen);
		
		//adds the imageholder label & image to panel_imageholder
		panel_imageholder.add(imageholder);
		
		//creates button to go back to the Start Menu
		back = new JButton("Back to Start Screen");
		
		//creates button to go to storyline2
		next1 = new JButton("Next");
		next2 = new JButton("Next");
		next3 = new JButton("Next");	//not being used now
		
		//creates button to go to storyline2 for CPU
		next1CPU = new JButton("Next");
		next2CPU = new JButton("Next");	//not being used now
		next3CPU = new JButton("Next");
		
		//creates button to go to Kids Mode
		toKidsMode = new JButton("Start!");
		
		//creates button to go to CPU Mode
		toCPUMode = new JButton("Start!");
		
		//Storyline Images
		
		//creates image icon for the 1st storyline image]
		storyline1 = new ImageIcon("src/storyline1.png");
		//creates image icon for the 2nd storyline image]
		storyline2 = new ImageIcon("src/storyline2.png");
		//creates image icon for the 3nd storyline image]   PATRICIA, here is where to put in the 3rd story line picture
		storyline3 = new ImageIcon("src/storyline3.png");	
		//creates image icon for the 3nd storyline image]
		//storyline2 = new ImageIcon("src/storyline2.png");
		
		
		//creates image icon for the 2nd storyline image for the CPU Guess Mode]
		storyline2CPU = new ImageIcon("src/storyline2CPU.png");
		//creates image icon for the 2nd storyline image for the CPU Guess Mode]	 PATRICIA, here is where to put in the 3rd story line picture
		storyline3CPU = new ImageIcon("src/CPUscreen2.png");
		//creates image icon for the 2nd storyline image for the CPU Guess Mode]
		storyline4CPU = new ImageIcon("src/CPUscreen3.png");
		

		//actions for the buttons
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline1);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(next1);
				panel_holding2buttons.remove(btnInstructions);
				splitPane.remove(btnNewButton_1);
				splitPane.remove(btnNewButton);
				repaint();
			}});  
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline1);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(next1CPU);
				panel_holding2buttons.remove(btnInstructions);
				splitPane.remove(btnNewButton_1);
				splitPane.remove(btnNewButton);
				repaint();
			}});
		
		next1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline2);
				panel_holding2buttons.remove(next1);
				panel_holding2buttons.add(toKidsMode);
				repaint();
			}});  
		/*next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline3);
				panel_holding2buttons.remove(next2);
				panel_holding2buttons.add(toKidsMode);	//if adding another screen switch add next 3 instead
				repaint();
			}}); */
		/*Didn't know how many story line screens you want, you can uncomment this if you need more
		 next3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline4);
				panel_holding2buttons.remove(next3);
				panel_holding2buttons.add(toKidsMode);
				repaint();
			}}); */ 
		
		next1CPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline2CPU);
				panel_holding2buttons.remove(next1CPU);
				panel_holding2buttons.add(next2CPU);
				repaint();
			}});  
		next2CPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline3CPU);
				panel_holding2buttons.remove(next2CPU);
				panel_holding2buttons.add(next3CPU);
				repaint();
			}}); 
		//Didn't know how many story line screens you want, you can uncomment this if you need more
		next3CPU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline4CPU);
				panel_holding2buttons.remove(next3CPU);
				panel_holding2buttons.add(toCPUMode);
				repaint();
			}});  
			
		
		toKidsMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Kids Guess Mode tab
				panel.reset();
				tabbedPane.setSelectedComponent(panel); 
			}});  
		toCPUMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Computer Guess Mode tab
				panel_1.reset();
				tabbedPane.setSelectedComponent(panel_1); 
			}});  
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Kids Guess Mode tab
				tabbedPane.setSelectedComponent(panel); 
			}});  */
		/*
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Computer Guess Mode tab
				tabbedPane.setSelectedComponent(panel_1); 
			}}); */
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the binarysearch image onto the imageholder
				imageholder.setIcon(binarysearch);
				//adds back button to panel holding 2 buttons
				panel_holding2buttons.add(back);
				repaint();
			}});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the startscreen image onto the imageholder
				imageholder.setIcon(startscreen);
				panel_holding2buttons.add(btnInstructions);
				splitPane.setRightComponent(btnNewButton_1); 
				splitPane.setLeftComponent(btnNewButton); 
				panel_holding2buttons.remove(back);
				panel_holding2buttons.remove(next1);
				panel_holding2buttons.remove(next1CPU);
				panel_holding2buttons.remove(toKidsMode);
				panel_holding2buttons.remove(toCPUMode);
				repaint();
			}});


		
	
		
	}

}
