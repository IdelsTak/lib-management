import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Write a description of class LibraryManagement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryManagement
{
   private final JFrame mainWindow;
    private final MenuController menuController;
    private final ActionListener showAddBookWindowAction;
    private final ActionListener showDeleteBookWindowAction;
    private final ActionListener showViewBooksWindowAction;
    private final ActionListener showIssueBookWindowAction;
    private final ActionListener showReturnBookWindowAction;
    private final ActionListener quitAction;
    private final Library library;

    public LibraryManagement() {
        mainWindow = new MainWindow("DataFlair Library");

        showAddBookWindowAction = new ShowAddBookWindowAction();
        showDeleteBookWindowAction = new ShowDeleteBookWindowAction();
        showViewBooksWindowAction = new ShowViewsBookWindowAction();
        showIssueBookWindowAction = new ShowIssueBookWindowAction();
        showReturnBookWindowAction = new ShowReturnBookWindowAction();
        quitAction = new QuitAction();

        library = new Library(MsAccessDatasource.getInstance().getConnection());

        menuController = new MenuController(this);
    }

    public void showMainWindow() {
        EventQueue.invokeLater(() -> {
            mainWindow.setVisible(true);
            this.showMenu();
        });
    }

    public Library getLibrary() {
        return library;
    }

    public JFrame getMainView() {
        return mainWindow;
    }

    public void showMenu() {
        ((MainWindow) mainWindow).setPage(menuController.getView());
    }

    public ActionListener getShowAddBookWindowAction() {
        return showAddBookWindowAction;
    }

    public ActionListener getShowDeleteBookWindowAction() {
        return showDeleteBookWindowAction;
    }

    public ActionListener getShowViewBooksWindowAction() {
        return showViewBooksWindowAction;
    }

    public ActionListener getShowIssueBookWindowAction() {
        return showIssueBookWindowAction;
    }

    public ActionListener getShowReturnBookWindowAction() {
        return showReturnBookWindowAction;
    }

    public ActionListener getQuitAction() {
        return quitAction;
    }

    private class ShowAddBookWindowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ((MainWindow) mainWindow).setPage(new AddBookController(LibraryManagement.this).getView());
        }

    }

    private class ShowDeleteBookWindowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ((MainWindow) mainWindow).setPage(new DeleteBookController(LibraryManagement.this).getView());
        }

    }

    private class ShowViewsBookWindowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ((MainWindow) mainWindow).setPage(new BooksTableController(LibraryManagement.this).getView());
        }

    }

    private class ShowIssueBookWindowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ((MainWindow) mainWindow).setPage(new IssueBookController(LibraryManagement.this).getView());
        }

    }

    private class ShowReturnBookWindowAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            ((MainWindow) mainWindow).setPage(new ReturnBookController(LibraryManagement.this).getView());
        }

    }

    private class QuitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            mainWindow.setVisible(false);
            mainWindow.dispose();
        }

    }
}
