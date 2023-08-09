import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BooksTableController implements Controller {

    private final LibraryManagement management;
    private final BooksTablePanel booksTablePanel;
    private final JPanel bookWindow;

    public BooksTableController(LibraryManagement management) {
        this.management = management;

        booksTablePanel = new BooksTablePanel();
        bookWindow = new BookWindow("View Books", booksTablePanel);

        ((BookWindow) bookWindow).getQuitButton().addActionListener(management.getQuitAction());
        ((BookWindow) bookWindow).getSubmitButton().addActionListener(new SubmitViewBooksAction());

        this.refreshTable();
    }

    @Override
    public JPanel getView() {
        return bookWindow;
    }

    private void refreshTable() {
        Library library = management.getLibrary();
        List<Book> books = library.getBooks();

        books.stream()
                .map(book -> {
                    String bookId = book.getId();
                    Lend lend = library.getLend(bookId);
                    String student = null;

                    if (lend != null) {
                        student = lend.getStudent();
                    }

                    return new Object[]{bookId, book.getTitle(), book.getAuthor(), book.getStatus(), student};
                })
                .forEach(row -> {
                    JTable table = booksTablePanel.getBooksTable();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    model.addRow(row);
                });
    }

    private class SubmitViewBooksAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            management.showMenu();
        }

    }
}
