package example1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
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
	
	//private KidsGuessGame panel;
	private JPanel panel;
	private KidsGuessGame panel_Kids_Guess;
	private JButton reset_Kids_Guess;
	private JButton Computer_to_Kids;
	
	private JPanel panel_0;
	private JTabbedPane tabbedPane;
	
	private JPanel panel_1;
	private ComputerGuessGame panel_Computer_Guess;
	private JButton reset_Computer_Guess;
	
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
	private ImageIcon storyline0;
	private ImageIcon storyline00;
	private ImageIcon storyline2;
	private ImageIcon storyline3;
	private ImageIcon storyline4;		//not being used now
	
	private ImageIcon storyline2CPU;
	private ImageIcon storyline3CPU;
	private ImageIcon storyline4CPU;	//not being used now
	
	private ImageIcon binarysearch1;
	private ImageIcon binarysearch2;
	private ImageIcon binarysearch3;
	private ImageIcon binarysearch4;
	private ImageIcon binarysearch5;
	private ImageIcon binarysearch6;
	
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
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
		setTitle("Binary Search Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 15000, 900);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//creates tabbed buttons pane at the top of the screen
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		ImageIcon arrow = new ImageIcon("src/green_arrow.png");
		ImageIcon back_arrow = new ImageIcon("src/red_arrow.png");

		
		//creates Start Screen panel
		panel_0 = new JPanel(); 
		//createsStart Screen tab
		tabbedPane.addTab("Start Screen", null, panel_0, null); 
		//creates a BorderLayout for the Start Screen panel
		panel_0.setLayout(new BorderLayout(0, 0));
		
		//creates panel that holds the 2 buttons
		panel_holding2buttons = new JPanel();
		//panel_holding2buttons.setLayout(new BorderLayout(0, 0));
		//splits the holding2buttons panel into 2 for the Kids Guess Mode button & the Computer Guess Mode button
		splitPane = new JSplitPane();
		//adds the holding2buttons panel to the center section of panel_0, the start screen panel
		panel_0.add(panel_holding2buttons, BorderLayout.CENTER);
		
		//adds the split panel to the holding2buttons panel
		//panel_holding2buttons.add(splitPane);
		
		//creates button for Kids Guess Mode
		btnNewButton = new JButton("Kids Guess Mode");
		btnNewButton.setPreferredSize(new Dimension(350,100));
		Font f = new Font("ariel", Font.PLAIN, 25);
		btnNewButton.setFont(f);

		//puts button in left pane that was previously split
		//splitPane.setLeftComponent(btnNewButton); 
		
		//creates button for Computer Guess Mode
		btnNewButton_1 = new JButton("Next");
		btnNewButton_1.setPreferredSize(new Dimension(350,100));
		btnNewButton_1.setFont(f);
		
		btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setPreferredSize(new Dimension(350,100));
		btnNewButton_2.setFont(f);

		btnNewButton_3 = new JButton("Next");
		btnNewButton_3.setPreferredSize(new Dimension(350,100));
		btnNewButton_3.setFont(f);
		
		btnNewButton_4 = new JButton("Next");
		btnNewButton_4.setPreferredSize(new Dimension(350,100));
		btnNewButton_4.setFont(f);
		
		btnNewButton_5 = new JButton("Next");
		btnNewButton_5.setPreferredSize(new Dimension(350,100));
		btnNewButton_5.setFont(f);
		
		btnNewButton_6 = new JButton("Next");
		btnNewButton_6.setPreferredSize(new Dimension(350,100));
		btnNewButton_6.setFont(f);
		
		//puts button in right pane that was previously split
		//splitPane.setRightComponent(btnNewButton_1); 
		
		//creates button for Instructions
		btnInstructions = new JButton("What's Binary Search?");
		btnInstructions.setPreferredSize(new Dimension(350,100));
		btnInstructions.setFont(f);
		btnInstructions.setBackground(Color.GREEN);
		btnInstructions.setOpaque(true);
		//adds the instructions button to the panel_holding2buttons
		panel_holding2buttons.add(btnInstructions);
		
		//creates Kids Guess Mode panel
		panel = new JPanel();
		panel_Kids_Guess = new KidsGuessGame();
		panel.setLayout(null);
		panel.add(panel_Kids_Guess); ////////////////////////////////////////////////////////
		panel_Kids_Guess.setBounds(0,0,1500,720);
		reset_Kids_Guess = new JButton("BACK TO START SCREEN");
		reset_Kids_Guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageholder.setIcon(startscreen);
				panel_holding2buttons.add(btnInstructions);
				splitPane.setRightComponent(btnNewButton_1); 
				splitPane.setLeftComponent(btnNewButton); 
				panel_holding2buttons.remove(back);
				panel_holding2buttons.remove(next1);
				panel_holding2buttons.remove(next1CPU);
				panel_holding2buttons.remove(toKidsMode);
				panel_holding2buttons.remove(toCPUMode);
				tabbedPane.setSelectedComponent(panel_0); 
				repaint();
			}		
		});

		panel.add(reset_Kids_Guess);
		reset_Kids_Guess.setBounds(0, 730, 270, 70);
		reset_Kids_Guess.setIcon(back_arrow);
		//panel.add(back);
		//creates Kids Guess Mode tab
		tabbedPane.addTab("Kids Game", null, panel, null); 
		
		//creates Computer Guess Mode panel
		panel_1 = new JPanel(); 
		panel_Computer_Guess = new ComputerGuessGame();
		//panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));///////////
		panel_1.setLayout(null);

		panel_1.add(panel_Computer_Guess);
		panel_Computer_Guess.setBounds(0,0,1500,720);

		reset_Computer_Guess = new JButton("BACK TO START SCREEN");
		reset_Computer_Guess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageholder.setIcon(startscreen);
				panel_holding2buttons.add(btnInstructions);
				splitPane.setRightComponent(btnNewButton_1); 
				splitPane.setLeftComponent(btnNewButton); 
				panel_holding2buttons.remove(back);
				panel_holding2buttons.remove(next1);
				panel_holding2buttons.remove(next1CPU);
				panel_holding2buttons.remove(toKidsMode);
				panel_holding2buttons.remove(toCPUMode);
				tabbedPane.setSelectedComponent(panel_0); 
				repaint();
			}		
		});
		panel_1.add(reset_Computer_Guess);
		reset_Computer_Guess.setBounds(0, 730, 270, 70);
		reset_Computer_Guess.setIcon(back_arrow);

		Computer_to_Kids = new JButton("NEXT");
		Computer_to_Kids.setIcon(arrow);
		Computer_to_Kids.setBackground(Color.GREEN);
		Computer_to_Kids.setOpaque(true);
		//Computer_to_Kids.setForeground(Color.GREEN);
		Computer_to_Kids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageholder.setIcon(storyline0);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(next1);
				panel_holding2buttons.remove(btnInstructions);
				panel_holding2buttons.remove(toCPUMode);
				//splitPane.remove(btnNewButton_1);
				//splitPane.remove(btnNewButton);
				tabbedPane.setSelectedComponent(panel_0); 
				repaint();

			}		
		});
		panel_1.add(Computer_to_Kids);
		Computer_to_Kids.setBounds(1200, 730, 200, 70);

		//panel_1.add(back);
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
		next1.setPreferredSize(new Dimension(350,100));
		next1.setFont(f);
		next1.setIcon(arrow);

		next2 = new JButton("Next");
		
		next3 = new JButton("Next");	//not being used now
		
		//creates button to go to storyline2 for CPU
		next1CPU = new JButton("Next");
		next1CPU.setPreferredSize(new Dimension(350,100));
		next1CPU.setFont(f);
		next1CPU.setIcon(arrow);

		next2CPU = new JButton("Next");
		next2CPU.setPreferredSize(new Dimension(350,100));
		next2CPU.setFont(f);
		next2CPU.setIcon(arrow);


		next3CPU = new JButton("Next");
		next3CPU.setPreferredSize(new Dimension(350,100));
		next3CPU.setFont(f);
		next3CPU.setIcon(arrow);

		
		//creates button to go to Kids Mode
		toKidsMode = new JButton("Start!");
		toKidsMode.setPreferredSize(new Dimension(350,100));
		toKidsMode.setFont(f);
		toKidsMode.setIcon(arrow);

		
		//creates button to go to CPU Mode
		toCPUMode = new JButton("Start!");
		toCPUMode.setPreferredSize(new Dimension(350,100));
		toCPUMode.setFont(f);
		toCPUMode.setIcon(arrow);

		
		//Storyline Images
		storyline0 = new ImageIcon("src/clonescreen.png");
		storyline00 = new ImageIcon("src/realheroscreen.png");
		
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
		
		//creates image icons for binarysearch instructions
		binarysearch1 = new ImageIcon("src/binarysearch1.png");
		binarysearch2 = new ImageIcon("src/binarysearch2.png");
		binarysearch3 = new ImageIcon("src/binarysearch3.png");
		binarysearch4 = new ImageIcon("src/binarysearch4.png");
		binarysearch5 = new ImageIcon("src/binarysearch5.png");
		binarysearch6 = new ImageIcon("src/binarysearch6.png");

		//actions for the buttons
		btnNewButton.setIcon(arrow);;
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
		
		btnNewButton_1.setIcon(arrow);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(binarysearch2);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_2);
				//panel_holding2buttons.remove(btnInstructions);
				panel_holding2buttons.remove(btnNewButton_1);
				//splitPane.remove(btnNewButton);
				repaint();
			}});
		
		btnNewButton_2.setIcon(arrow);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(binarysearch3);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_3);
				panel_holding2buttons.remove(btnNewButton_2);
				repaint();
			}});
		
		btnNewButton_3.setIcon(arrow);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(binarysearch4);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_4);
				panel_holding2buttons.remove(btnNewButton_3);
				repaint();
			}});
		
		btnNewButton_4.setIcon(arrow);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(binarysearch5);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_5);
				panel_holding2buttons.remove(btnNewButton_4);
				repaint();
			}});
		
		btnNewButton_5.setIcon(arrow);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(binarysearch6);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_6);
				panel_holding2buttons.remove(btnNewButton_5);
				repaint();
			}});
		
		btnNewButton_6.setIcon(arrow);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline1);
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(next1CPU);
				panel_holding2buttons.remove(btnNewButton_6);
				repaint();
			}});
		
		next1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to storyline1 image
				imageholder.setIcon(storyline00);
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
				panel_Kids_Guess.reset();
				tabbedPane.setSelectedComponent(panel); 
			}});  
		toCPUMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Computer Guess Mode tab
				panel_Computer_Guess.reset();
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
				imageholder.setIcon(binarysearch1);
				//adds back button to panel holding 2 buttons
				panel_holding2buttons.add(back);
				panel_holding2buttons.add(btnNewButton_1);
				panel_holding2buttons.remove(btnInstructions);
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
				panel_holding2buttons.remove(next2CPU);
				panel_holding2buttons.remove(next3CPU);
				panel_holding2buttons.remove(toKidsMode);
				panel_holding2buttons.remove(toCPUMode);
				panel_holding2buttons.remove(btnNewButton_2);
				panel_holding2buttons.remove(btnNewButton_3);
				panel_holding2buttons.remove(btnNewButton_4);
				panel_holding2buttons.remove(btnNewButton_5);
				panel_holding2buttons.remove(btnNewButton_6);
				
				repaint();
			}});


		
	
		
	}

}
