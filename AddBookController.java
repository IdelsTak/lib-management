
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class AddBookController implements Controller {

    private final LibraryManagement management;
    private final BookDetailsPanel detailsPanel;
    private final JPanel bookWindow;

    public AddBookController(LibraryManagement management) {
        this.management = management;

        detailsPanel = new BookDetailsPanel();
        bookWindow = new BookWindow("Add Book Details", detailsPanel);

        ((BookWindow) bookWindow).getQuitButton().addActionListener(management.getQuitAction());
        ((BookWindow) bookWindow).getSubmitButton().addActionListener(new AddBookAction());
    }

    @Override
    public JPanel getView() {
        return bookWindow;
    }

    private class AddBookAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            String id = detailsPanel.getBookIdTextField().getText();
            String title = detailsPanel.getTitleTextField().getText();
            String author = detailsPanel.getAuthorTextField().getText();
            String status = detailsPanel.getStatusTextField().getText();

            if (id != null && id.trim().length() > 0) {
                management.getLibrary().addBook(new Book(id, title, author, status));
            }

            management.showMenu();
        }

    }
}
