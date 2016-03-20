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
		
		//splits the Start Screen panel into 2 for the Kids Guess Mode button & the Computer Guess Mode button
		JSplitPane splitPane = new JSplitPane();
		panel_0.add(splitPane);
		
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
