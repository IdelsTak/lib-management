import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BookWindow extends JPanel {

    private final String title;
    private final JPanel detailsPanel;
    private final JButton submitButton;
    private final JButton quitButton;

    public BookWindow(String title, JPanel detailsPanel) {
        super(new BorderLayout());

        submitButton = new JButton("SUBMIT");
        quitButton = new JButton("Quit");

        this.title = title;
        this.detailsPanel = detailsPanel;

        this.initComponents();
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    private void initComponents() {
        super.add(this.createTopPanel(), BorderLayout.NORTH);
        super.add(this.createCenterPanel(), BorderLayout.CENTER);
        super.add(this.createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(Color.white);

        Box.Filler northFiller = new Box.Filler(new Dimension(0, 24), new Dimension(0, 24), new Dimension(32767, 24));
        Box.Filler westFiller = new Box.Filler(new Dimension(200, 0), new Dimension(200, 0), new Dimension(0, 0));
        Box.Filler eastFiller = new Box.Filler(new Dimension(200, 0), new Dimension(200, 0), new Dimension(0, 0));
        Box.Filler southFiller = new Box.Filler(new Dimension(0, 12), new Dimension(0, 12), new Dimension(32767, 12));

        panel.add(northFiller, BorderLayout.NORTH);
        panel.add(westFiller, BorderLayout.WEST);
        panel.add(this.createMainTitlePanel(), BorderLayout.CENTER);
        panel.add(eastFiller, BorderLayout.EAST);
        panel.add(southFiller, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());

        centerPanel.setBackground(Color.white);

        Box.Filler westFiller = new Box.Filler(new Dimension(36, 0), new Dimension(36, 0), new Dimension(36, 32767));
        Box.Filler eastFiller = new Box.Filler(new Dimension(36, 0), new Dimension(36, 0), new Dimension(36, 32767));
        Box.Filler southFiller = new Box.Filler(new Dimension(0, 12), new Dimension(0, 12), new Dimension(32767, 12));

        centerPanel.add(westFiller, BorderLayout.WEST);
        centerPanel.add(detailsPanel, BorderLayout.CENTER);
        centerPanel.add(eastFiller, BorderLayout.EAST);
        centerPanel.add(southFiller, BorderLayout.SOUTH);

        return centerPanel;
    }

    private JPanel createBottomPanel() {
        JPanel southPanel = new JPanel(new GridLayout(1, 0, 48, 0));

        southPanel.setBackground(Color.white);
        southPanel.setBorder(BorderFactory.createEmptyBorder(24, 1, 24, 1));

        Box.Filler westFiller = new Box.Filler(new Dimension(90, 0), new Dimension(90, 0), new Dimension(90, 32767));
        southPanel.add(westFiller);

        submitButton.setMinimumSize(new Dimension(150, 50));
        submitButton.setPreferredSize(new Dimension(150, 50));
        southPanel.add(submitButton);

        quitButton.setMinimumSize(new Dimension(150, 50));
        quitButton.setPreferredSize(new Dimension(150, 50));
        southPanel.add(quitButton);

        Box.Filler eastFiller = new Box.Filler(new Dimension(90, 0), new Dimension(90, 0), new Dimension(90, 32767));
        southPanel.add(eastFiller);

        return southPanel;
    }

    private JPanel createMainTitlePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(Color.darkGray);
        panel.setBorder(BorderFactory.createEmptyBorder(24, 80, 24, 80));
        panel.setMinimumSize(new Dimension(100, 100));
        panel.setPreferredSize(new Dimension(100, 100));

        Box.Filler northFiller = new Box.Filler(new Dimension(0, 12), new Dimension(0, 12), new Dimension(32767, 12));
        Box.Filler westFiller = new Box.Filler(new Dimension(18, 0), new Dimension(18, 0), new Dimension(18, 32767));
        Box.Filler eastFiller = new Box.Filler(new Dimension(18, 0), new Dimension(18, 0), new Dimension(18, 32767));
        Box.Filler southFiller = new Box.Filler(new Dimension(0, 12), new Dimension(0, 12), new Dimension(32767, 12));

        panel.add(northFiller, BorderLayout.NORTH);
        panel.add(westFiller, BorderLayout.WEST);
        panel.add(this.createTitlePanel(), BorderLayout.CENTER);
        panel.add(eastFiller, BorderLayout.EAST);
        panel.add(southFiller, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(Color.white);

        JLabel titleLabel = new JLabel(title);

        Font defaultFont = titleLabel.getFont();
        Font titleFont = defaultFont.deriveFont(defaultFont.getStyle() | Font.BOLD, defaultFont.getSize() + 2);

        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.CENTER);

        return panel;
    }

}
