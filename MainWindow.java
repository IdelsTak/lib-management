import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private final JPanel mainPanel;

    public MainWindow(String libraryName) {
        super(libraryName);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // super.setResizable(false);

        mainPanel = new JPanel(new BorderLayout());

        mainPanel.setPreferredSize(new Dimension(800, 600));

        // Add main panel to the frame container
        super.getContentPane().add(mainPanel);

        // Layout the components
        super.pack();

        // Center the frame on screen
        super.setLocationRelativeTo(null);
    }

    public void setPage(JPanel panel) {
        mainPanel.removeAll();

        mainPanel.add(panel, BorderLayout.CENTER);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
