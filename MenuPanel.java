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
import javax.swing.border.Border;

public class MenuPanel extends JPanel {

    private static final Color FOREGROUND_COLOR = Color.WHITE;
    private static final Color BACKGROUND_COLOR = Color.DARK_GRAY;
    private static final Font DEFAULT_FONT = new JLabel().getFont();
    private final JButton addBookButton;
    private final JButton deleteBookButton;
    private final JButton viewBooksButton;
    private final JButton issueBookButton;
    private final JButton returnBookButton;

    public MenuPanel(String libraryName) {
        super(new BorderLayout());

        addBookButton = new JButton("Add Book Details");
        deleteBookButton = new JButton("Delete Book");
        viewBooksButton = new JButton("View Book List");
        issueBookButton = new JButton("Issue Book to Student");
        returnBookButton = new JButton("Return Book");

        this.initComponents(libraryName);
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }

    public JButton getDeleteBookButton() {
        return deleteBookButton;
    }

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public JButton getIssueBookButton() {
        return issueBookButton;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    private void initComponents(String libraryName) {
        super.setBackground(BACKGROUND_COLOR);
        super.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        //  Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(BACKGROUND_COLOR);
        Border outsideBorder = BorderFactory.createLineBorder(Color.orange, 1);
        Border insideBorder = BorderFactory.createEmptyBorder(12, 12, 12, 12);
        titlePanel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

        // Title label properties
        Font largeFont = DEFAULT_FONT.deriveFont(DEFAULT_FONT.getSize() + 10f);
        String title = String.format("<html><body style=\"text-align: center;\">Welcome to<p>%s</html>", libraryName);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(largeFont);
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add title label to title panel
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        // Add title panel to main panel
        super.add(titlePanel, BorderLayout.NORTH);

        // Buttons panel properties
        JPanel buttonsPanel = new JPanel(new GridLayout(0, 1));
        buttonsPanel.setBackground(BACKGROUND_COLOR);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(12, 6, 12, 6));
        buttonsPanel.setPreferredSize(new Dimension(550, 350));

        // Add book button
        addBookButton.setBackground(BACKGROUND_COLOR);
        addBookButton.setForeground(FOREGROUND_COLOR);

        // Delete book button
        deleteBookButton.setBackground(BACKGROUND_COLOR);
        deleteBookButton.setForeground(FOREGROUND_COLOR);

        // View books button
        viewBooksButton.setBackground(BACKGROUND_COLOR);
        viewBooksButton.setForeground(FOREGROUND_COLOR);
        // View books button

        issueBookButton.setBackground(BACKGROUND_COLOR);
        issueBookButton.setForeground(FOREGROUND_COLOR);

        // Return book button
        returnBookButton.setBackground(BACKGROUND_COLOR);
        returnBookButton.setForeground(FOREGROUND_COLOR);

        // Add buttons to buttons panel
        buttonsPanel.add(addBookButton);
        buttonsPanel.add(deleteBookButton);
        buttonsPanel.add(viewBooksButton);
        buttonsPanel.add(issueBookButton);
        buttonsPanel.add(returnBookButton);

        // Add buttons panel to main panel
        super.add(buttonsPanel, BorderLayout.CENTER);

        // Fillers
        Dimension fillerDim = new Dimension(100, 0);
        Box.Filler westFiller = new Box.Filler(fillerDim, fillerDim, fillerDim);
        Box.Filler eastFiller = new Box.Filler(fillerDim, fillerDim, fillerDim);

        // Add fillers to west and east sides
        // of the main panel
        super.add(westFiller, BorderLayout.WEST);
        super.add(eastFiller, BorderLayout.EAST);
    }

}
