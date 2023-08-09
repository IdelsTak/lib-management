import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class IssueBookController implements Controller {

    private final LibraryManagement management;
    private final BookIssuePanel bookIssuePanel;
    private final JPanel bookWindow;

    public IssueBookController(LibraryManagement management) {
        this.management = management;

        bookIssuePanel = new BookIssuePanel();
        bookWindow = new BookWindow("Issue Book", bookIssuePanel);

        ((BookWindow) bookWindow).getQuitButton().addActionListener(management.getQuitAction());
        ((BookWindow) bookWindow).getSubmitButton().addActionListener(new SubmitIssueBookAction());
    }

    @Override
    public JPanel getView() {
        return bookWindow;
    }

    private class SubmitIssueBookAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            String student = bookIssuePanel.getIssueToTextField().getText();
            String bookId = bookIssuePanel.getBookIdTextField().getText();

            if (student != null && bookId != null) {
                Library library = management.getLibrary();
                Book book = library.getBook(bookId.trim());

                if (book != null) {
                    library.issueBook(new Lend(student, book));
                }
            }

            management.showMenu();
        }

    }

}
