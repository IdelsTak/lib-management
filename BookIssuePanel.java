import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class BookIssuePanel extends JPanel {

    private final JTextField bookIdTextField;
    private final JTextField issueToTextField;

    public BookIssuePanel() {
        setLayout(new GroupLayout(this));
        setBackground(Color.DARK_GRAY);

        bookIdTextField = new JTextField();
        issueToTextField = new JTextField();

        this.initComponents();
    }

    public JTextField getBookIdTextField() {
        return bookIdTextField;
    }

    public JTextField getIssueToTextField() {
        return issueToTextField;
    }

    private void initComponents() {
        JLabel bookIdLabel = new JLabel("Book Id");
        JLabel issueToLabel = new JLabel("Issue To");

        bookIdLabel.setForeground(Color.WHITE);
        issueToLabel.setForeground(Color.WHITE);

        GroupLayout layout = (GroupLayout) getLayout();

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(bookIdLabel)
                                        .addComponent(issueToLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(issueToTextField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                        .addComponent(bookIdTextField))
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
                                        .addComponent(issueToLabel)
                                        .addComponent(issueToTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
