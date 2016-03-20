package example1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
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
	
	public TabbedIntegratedScreens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//creates tabbed buttons pane at the top of the screen
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		//creates Start Screen panel & tab
		JPanel panel_0 = new JPanel(); //Start Screen panel
		tabbedPane.addTab("Start Screen", null, panel_0, null); //Start Screen tab
		
		//splits the Start Screen panel into 2 for the Kids Guess Mode button & the Computer Guess Mode button
		JSplitPane splitPane = new JSplitPane();
		panel_0.add(splitPane);
		
		//creates button for Kids Guess Mode
		JButton btnNewButton = new JButton("Kids Guess Mode");
		splitPane.setLeftComponent(btnNewButton); //puts button in left pane that was previously split
		
		//creates button for Computer Guess Mode
		JButton btnNewButton_1 = new JButton("Computer Guess Mode");
		splitPane.setRightComponent(btnNewButton_1); //puts button in right pane that was previously split
		
		//creates Kids Guess Mode panel & tab
		panel = new KidsGuessGame(); //Kids Guess Mode panel
		tabbedPane.addTab("Kids Game", null, panel, null); //Kids Guess Mode tab
		
		//creates Computer Guess Mode panel & tab
		panel_1 = new ComputerGuessGame(); //Computer Guess Mode panel
		tabbedPane.addTab("Computer Game", null, panel_1, null); //Computer Guess Mode tab
		
		//actions for the buttons
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(panel); //switch tab to Kids Guess Mode tab
			}});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(panel_1); //switch tab to Computer Guess Mode tab
			}
		}
		);
	}

}
