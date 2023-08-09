import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class BookDetailsPanel extends JPanel {

    private final JTextField bookIdTextField;
    private final JTextField titleTextField;
    private final JTextField authorTextField;
    private final JTextField statusTextField;

    public BookDetailsPanel() {
        setLayout(new GroupLayout(this));
        setPreferredSize(new Dimension(180, 300));
        setBackground(Color.DARK_GRAY);

        bookIdTextField = new JTextField();
        titleTextField = new JTextField();
        authorTextField = new JTextField();
        statusTextField = new JTextField();

        this.initComponents();
    }

    public JTextField getBookIdTextField() {
        return bookIdTextField;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public JTextField getAuthorTextField() {
        return authorTextField;
    }

    public JTextField getStatusTextField() {
        return statusTextField;
    }

    private void initComponents() {
        JLabel bookIdLabel = new JLabel("Book Id");
        JLabel authorLabel = new JLabel("Author");
        JLabel titleLabel = new JLabel("Title");
        JLabel statusLabel = new JLabel("Status (Avail/Issued)");

        bookIdLabel.setForeground(Color.WHITE);
        authorLabel.setForeground(Color.WHITE);
        titleLabel.setForeground(Color.WHITE);
        statusLabel.setForeground(Color.WHITE);

        GroupLayout layout = (GroupLayout) getLayout();

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(bookIdLabel)
                                        .addComponent(titleLabel)
                                        .addComponent(authorLabel)
                                        .addComponent(statusLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(bookIdTextField)
                                        .addComponent(titleTextField)
                                        .addComponent(authorTextField)
                                        .addComponent(statusTextField))
                                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookIdLabel)
                                        .addComponent(bookIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(titleLabel)
                                        .addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(authorLabel)
                                        .addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusLabel)
                                        .addComponent(statusTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
