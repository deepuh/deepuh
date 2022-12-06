import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoadScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoadScreen() {
		super("Starting Screen");
	}
	
	public void start() {
		JFrame frame = new JFrame("Home page");
		  frame.setVisible(true);
		  frame.setSize(500,200);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  JPanel panel = new JPanel();
		  frame.add(panel);
		  JButton button = new JButton("Login");
		  panel.add(button);
		  button.addActionListener (new Action1());
		  
		    JLabel headerLabel;
		    headerLabel = new JLabel("Leftover's App", JLabel.CENTER);
		    panel.add(headerLabel);
		    headerLabel.setVisible(true);

		  JButton button2 = new JButton("About");
		  panel.add(button2);
		  button2.addActionListener(new Action2()); 
		}
		static class Action1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		    JFrame frame2 = new JFrame("Clicked");
		    frame2.setVisible(true);
		    frame2.setSize(200,200);
		    JLabel label = new JLabel("you clicked me");
		    JPanel panel = new JPanel();
		    frame2.add(panel);
		    panel.add(label);       
		  }
		}   
		static class Action2 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {    
			  Iteration1.main(null);
		  }
		}   
		
	public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
       public void run() {
            LoadScreen myFrame = new LoadScreen();
            myFrame.start();
        }
    });
}
}
//}
