import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Iteration2 extends JFrame{

    private static final Dimension FRAME_SIZE = new Dimension(550, 350);

    private JFrame frame;

    private JButton exportButton;

    private JButton importButton;

    private JPanel panel;

    private File savedFile;
    
    private File file = new File(".");

    private JFileChooser fileChooser = new JFileChooser();
    public Iteration2(){
        Initialize();
    }

    private void Initialize(){
        frame = new JFrame("Export / Import");
        frame.setVisible(true);
        frame.setSize(FRAME_SIZE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        exportButton = new JButton("Export");
        exportButton.setFocusable(false);
        importButton = new JButton("Import");
        importButton.setFocusable(false);
        panel.add(exportButton);
        panel.add(importButton);
        frame.add(panel, BorderLayout.CENTER);
        addExportEvent();
        addImportEvent();

    }

    private void addExportEvent(){
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("export button clicked");
                fileChooser.setDialogTitle("File to Export");
                int userSelection = fileChooser.showSaveDialog(frame);
                if(userSelection == fileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    System.out.println("File Exported to: "+file.getAbsolutePath());
                }
            }
        });
    }

    private void addImportEvent(){
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("import button clicked");
                fileChooser.setDialogTitle("File to Import");
                int userDestination = fileChooser.showOpenDialog(frame);
                if(userDestination == fileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    System.out.println("Selected file: "+file.getAbsolutePath());
                }
            }
        });
    }

    public static void main(final String [] theArgs) {
    	EventQueue.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			new Iteration2().Initialize();
    		}
    	});
    }
}