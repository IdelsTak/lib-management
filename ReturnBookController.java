import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ReturnBookController implements Controller {

    private final LibraryManagement management;
    private final BookIdPanel bookIdPanel;
    private final JPanel bookWindow;

    public ReturnBookController(LibraryManagement management) {
        this.management = management;

        bookIdPanel = new BookIdPanel();
        bookWindow = new BookWindow("Return Book", bookIdPanel);

        ((BookWindow) bookWindow).getQuitButton().addActionListener(management.getQuitAction());
        ((BookWindow) bookWindow).getSubmitButton().addActionListener(new SubmitReturnBookAction());
    }

    @Override
    public JPanel getView() {
        return bookWindow;
    }

    private class SubmitReturnBookAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            String bookId = bookIdPanel.getBookIdTextField().getText();

            if (bookId != null) {
                Library library = management.getLibrary();
                Lend lend = library.getLend(bookId);

                if (lend != null) {
                    library.returnBook(lend);
                }
            }

            management.showMenu();
        }

    }
}
