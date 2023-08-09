import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class BookIdPanel extends JPanel {

    private final JTextField bookIdTextField;

    public BookIdPanel() {
        setLayout(new GroupLayout(this));
        setPreferredSize(new Dimension(180, 300));
        setBackground(Color.DARK_GRAY);

        bookIdTextField = new JTextField();

        this.initComponents();
    }

    public JTextField getBookIdTextField() {
        return bookIdTextField;
    }

    private void initComponents() {
        JLabel bookIdLabel = new JLabel("BookId");

        bookIdLabel.setForeground(Color.WHITE);

        GroupLayout layout = (GroupLayout) getLayout();

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(bookIdLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bookIdTextField)
                                .addGap(48, 48, 48))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bookIdLabel)
                                        .addComponent(bookIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
