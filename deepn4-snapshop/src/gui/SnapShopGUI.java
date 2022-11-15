package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.Filter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is the SnapShop GUI class which is called by the main class 
 * and it creates all the buttons and frame for user to interact with.
 * 
 * @author Deep Singh @deepn4
 * @version AU 21
 */
public class SnapShopGUI {
    
    /** The JFrame for GUI */
    private final JFrame myFrame = new JFrame();
    
    /** JFileChooser to open and save files. */
    private final JFileChooser myFileChooser = new JFileChooser();
    
    /** Panel for the filters. */
    private final JPanel myFilterButtons = new JPanel(new FlowLayout());
    
    /** Panel for the menu. */
    private final JPanel myMenuButtons = new JPanel();

    /** directory for sample images. */
    private File myDirectory = new File("sample_images");
    
    /** Display image myImage. */
    private PixelImage myImage;
    
    /** Label to display the image. */
    private final JLabel myImageLabel = new JLabel(new ImageIcon());
    
    /** Array for all filters. */
    private final Filter[] myFilters = new Filter[] {
        new EdgeDetectFilter(), new EdgeHighlightFilter(), 
        new FlipHorizontalFilter(), new FlipVerticalFilter(),
        new GrayscaleFilter(), new SharpenFilter(), new SoftenFilter()
    };
    
    /** Array for all menu buttons. */
    private final JButton[] myButtons = new JButton[] {
        new JButton("Open..."),
        new JButton("Save As..."), new JButton("Close Image")
    };
    //end of fields
    
    /** constructor calls super method and also creates buttons for the GUI. */
    public SnapShopGUI() {
        super();
        createButtons(); //calls the createButtons method
    }
    
    /** Sets and starts the GUI. 
     * this method is called by the SnapShopMain class to run the GUI program.
     */
    public void start() {
        
        myFrame.setTitle("TCSS 305 - Assignment 5");
        final ImageIcon frameIcon = new ImageIcon("icons/smile.jpg");
        myFrame.setIconImage(frameIcon.getImage());
        
        myFrame.add(myFilterButtons, BorderLayout.NORTH);
        myFrame.add(myMenuButtons, BorderLayout.SOUTH);
        myFrame.add(myImageLabel, BorderLayout.CENTER);
        
        myFrame.setResizable(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        
        //buttons not enabled at start
        enableButtons(myFilterButtons, false);
        myButtons[1].setEnabled(false);
        myButtons[2].setEnabled(false);
    }
    
    /**
     * Creates filter buttons and attaches an ActionListener to it,
     * and connects the filter effect to the button.
     * 
     * @param theObject
     * @return JButton
     */
    private JButton createFilterButtons(final Filter theObject) {
        //new button
        final JButton button = new JButton(theObject.getDescription());
        //connects to filter effect attached to the new button.
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                theObject.filter(myImage);
                myImageLabel.setIcon(new ImageIcon(myImage)); //updated image
            }
        });
        return button;
    }
    
    /** this method creates filter and menu buttons. */
    private void createButtons() {
        //this makes the filter buttons using myFilters array
        for (int i = 0; i < myFilters.length; i++) {
            myFilterButtons.add(createFilterButtons(myFilters[i]));
        }
        //makes the menu buttons
        myMenuButtons.add(createOpenButton());
        myMenuButtons.add(createSaveButton());
        myMenuButtons.add(createCloseButton());
    }
    
    /**
     * Creates the Open button and attaches an ActionListener to it,
     * and connects the button to the file chooser.
     * 
     * @return JButton
     */
    private JButton createOpenButton() {
        myButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFileChooser.setCurrentDirectory(myDirectory);
                if (myFileChooser.showOpenDialog(myFrame) == JFileChooser.APPROVE_OPTION) {
                    myDirectory = myFileChooser.getCurrentDirectory();
                    try {
                        myImage = PixelImage.load(myFileChooser.getSelectedFile());
                        myImageLabel.setIcon(new ImageIcon(myImage));
                        enableButtons(myFilterButtons, true);
                        enableButtons(myMenuButtons, true);
                        myFrame.pack();
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(myFrame,
                                    "The selected file did not contain an image!",
                                    "Error! ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        return myButtons[0];
    }
    
    /**
     * Creates the Save button and attaches an ActionListener to it,
     * and connects the button to the save dialog.
     * if file exists, it overwrites the current file.
     * 
     * @return JButton save button.
     */
    private JButton createSaveButton() {
        myButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final int result = myFileChooser.showSaveDialog(myFrame);
                final File file = myFileChooser.getSelectedFile();
                if (result == JFileChooser.APPROVE_OPTION) {
                    if (file.exists()) { //overwrites
                        final int changeResult = JOptionPane.showConfirmDialog(myFrame, 
                                                     "File Already Exists, Overwrite?",
                                                     "Existing File", 
                                                     JOptionPane.YES_NO_CANCEL_OPTION);
                        if (changeResult == JOptionPane.YES_OPTION) {
                            try {
                                myImage.save(file);
                            } catch (final IOException e) {
                                JOptionPane.showMessageDialog(myFrame,
                                                            "Failed to Save! ", 
                                                            "Error!  ", 
                                                            JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else if (!file.exists()) {
                        try { //saves
                            myImage.save(file);
                        } catch (final IOException e) {
                            JOptionPane.showMessageDialog(myFrame, "Failed to Save!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        return myButtons[1];
    }
    
    /**
     * Creates the Close button and attaches an ActionListener to it,
     * and connects the button to image close action.

     * @return JButton close button.
     */
    private JButton createCloseButton() {
        myButtons[2].addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                //sets image to blank
                myImageLabel.setIcon(new ImageIcon());
                //reset buttons and resize frame
                enableButtons(myFilterButtons, false); 
                myButtons[1].setEnabled(false);
                myButtons[2].setEnabled(false);
                myFrame.pack();
            }
        });
        return myButtons[2];
    }
    /**
     * Enables or disables buttons, depending on the parameters.
     * 
     * @param JPanel thePanel
     * @param Boolean theEnabled
     */
    private void enableButtons(final JPanel thePanel, final boolean theEnabled) {
        for (int i = 0; i < thePanel.getComponentCount(); i++) {
            if (theEnabled) {
                thePanel.getComponent(i).setEnabled(true);
            } else {
                thePanel.getComponent(i).setEnabled(false);
            }
        }
    }
}