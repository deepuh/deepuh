import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.lang.Object;

public class Iteration1 extends JFrame {
	 private static final Dimension FRAME_SIZE = new Dimension(650, 350);
	  public Iteration1() {
	        super("Leftover's About Screen");

	    }

	    public void start() {

	        setVisible(true);
	        setSize(FRAME_SIZE);
	        setLocationRelativeTo(null);
	        //setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

	        JPanel containPanel = new JPanel();
	        GridLayout gridLayout = new GridLayout(1, 2);
	        containPanel.setLayout(gridLayout);
	        containPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

	        containPanel.add(createTeamInfoPanel());

	        this.add(containPanel);
	    }
	    private JPanel createTeamInfoPanel() {
	    	
	        JPanel teamInfoPnl = new JPanel();
	        teamInfoPnl.setLayout(new BorderLayout());

	        JPanel designerPnl = new JPanel();
	        designerPnl.setBorder(BorderFactory.createLineBorder(Color.black));
	        designerPnl.add(new JLabel("This app is registered to: " + VersionInfo.getUserName(), JLabel.CENTER));
	        
	        JPanel designerNamePnl = new JPanel();
	        designerNamePnl.setBorder(BorderFactory.createLineBorder(Color.black));
	        designerNamePnl.setLayout(new GridLayout(7, 1));
	        designerNamePnl.add(new JLabel("This app is provided by:", JLabel.CENTER));
	        designerNamePnl.add(new JLabel(VersionInfo.getD1(), JLabel.CENTER));
	        designerNamePnl.add(new JLabel(VersionInfo.getD2(), JLabel.CENTER));
	        designerNamePnl.add(new JLabel(VersionInfo.getD3(), JLabel.CENTER));
	        designerNamePnl.add(new JLabel(VersionInfo.getD4(), JLabel.CENTER));
	        designerNamePnl.add(new JLabel(VersionInfo.getD5(), JLabel.CENTER));

	        JPanel versionPnl = new JPanel();
	        versionPnl.setBorder(BorderFactory.createLineBorder(Color.black));
	        versionPnl.add(new JLabel("Version: " + VersionInfo.getVersion()));

	        teamInfoPnl.add(designerPnl, BorderLayout.NORTH);
	        teamInfoPnl.add(designerNamePnl, BorderLayout.CENTER);
	        teamInfoPnl.add(versionPnl, BorderLayout.SOUTH);

	        return teamInfoPnl;
	    }

	    /**
	     * Main method.
	     * 
	     * @param theArgs arguments.
	     */
	    public static void main(final String[] theArgs) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Iteration1().start();
	            }
	        });
	    }
}
