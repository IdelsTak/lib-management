import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class DeleteBookController implements Controller {

    private final LibraryManagement management;
    private final BookIdPanel idPanel;
    private final JPanel bookWindow;

    public DeleteBookController(LibraryManagement management) {
        this.management = management;

        idPanel = new BookIdPanel();
        bookWindow = new BookWindow("Delete Book", idPanel);

        ((BookWindow) bookWindow).getQuitButton().addActionListener(management.getQuitAction());
        ((BookWindow) bookWindow).getSubmitButton().addActionListener(new SubmitDeleteBookAction());
    }

    @Override
    public JPanel getView() {
        return bookWindow;
    }

    private class SubmitDeleteBookAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            String bookId = idPanel.getBookIdTextField().getText();

            if (bookId != null) {
                management.getLibrary().removeBook(bookId.trim());
            }
            
            management.showMenu();
        }

    }

}
