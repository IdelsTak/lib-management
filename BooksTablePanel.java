import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BooksTablePanel extends JPanel {

    private JTable booksTable;

    public BooksTablePanel() {
        super(new BorderLayout());

        this.initComponents();
    }

    public JTable getBooksTable() {
        return booksTable;
    }

    private void initComponents() {
        DefaultTableModel model = new Model();

        model.addColumn("Book Id");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Status");
        model.addColumn("Issued To");

        booksTable = new JTable(model);

        booksTable.setForeground(Color.WHITE);
        booksTable.setBackground(Color.DARK_GRAY);

        add(new JScrollPane(booksTable), BorderLayout.CENTER);
    }

    private class Model extends DefaultTableModel {

        private final boolean[] canEdit = new boolean[]{false, false, false, false, false};

        @Override
        public boolean isCellEditable(int row, int column) {
            return canEdit[column];
        }

    }

}
