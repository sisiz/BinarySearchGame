package example1;

import java.awt.BorderLayout;
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
	private JPanel panel_binarysearchintro;
	private JLabel binarysearchintro;
	private JPanel panel_holding2buttons;
	private ImageIcon binarysearchintroimage;
	
	public TabbedIntegratedScreens() {
		//initiates background template
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		JPanel panel_holding2buttons = new JPanel();
		//splits the holding2buttons panel into 2 for the Kids Guess Mode button & the Computer Guess Mode button
		JSplitPane splitPane = new JSplitPane();
		//adds the holding2buttons panel to the center section of panel_0, the start screen panel
		panel_0.add(panel_holding2buttons, BorderLayout.CENTER);
		//adds the split panel to the holding2buttons panel
		panel_holding2buttons.add(splitPane);
		
		//creates button for Kids Guess Mode
		JButton btnNewButton = new JButton("Kids Guess Mode");
		//puts button in left pane that was previously split
		splitPane.setLeftComponent(btnNewButton); 
		
		//creates button for Computer Guess Mode
		JButton btnNewButton_1 = new JButton("Computer Guess Mode");
		//puts button in right pane that was previously split
		splitPane.setRightComponent(btnNewButton_1); 
		
		//creates Kids Guess Mode panel
		panel = new KidsGuessGame(); 
		//creates Kids Guess Mode tab
		tabbedPane.addTab("Kids Game", null, panel, null); 
		
		//creates Computer Guess Mode panel
		panel_1 = new ComputerGuessGame(); 
		//creates Computer Guess Mode tab
		tabbedPane.addTab("Computer Game", null, panel_1, null);
		
		//creates the panel holding the binary search intro
		JPanel panel_binarysearchintro = new JPanel();
		//adds the panel holding the binary search intro to the north section of panel_0, the start screen panel
		panel_0.add(panel_binarysearchintro, BorderLayout.NORTH);
		
		//creates label for the binary search intro image
		binarysearchintro = new JLabel();
		//creates an image icon for the binary search intro image
		ImageIcon binarysearchintroimage = new ImageIcon("src/binarysearchstartscreen.png");
		//sets the image icon onto the binarysearchintro label
		binarysearchintro.setIcon(binarysearchintroimage);
		//adds the binarysearchintro label & image to panel_binarysearchintro
		panel_binarysearchintro.add(binarysearchintro);
		
		//actions for the buttons
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Kids Guess Mode tab
				tabbedPane.setSelectedComponent(panel); 
			}});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch tab to Computer Guess Mode tab
				tabbedPane.setSelectedComponent(panel_1); 
			}
		}
		);
	}

}
