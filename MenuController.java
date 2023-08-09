import javax.swing.JPanel;

public class MenuController implements Controller {

    private final JPanel menuPanel;

    public MenuController(LibraryManagement mgmgt) {
        menuPanel = new MenuPanel(mgmgt.getMainView().getTitle());

        ((MenuPanel) menuPanel).getAddBookButton().addActionListener(mgmgt.getShowAddBookWindowAction());
        ((MenuPanel) menuPanel).getDeleteBookButton().addActionListener(mgmgt.getShowDeleteBookWindowAction());
        ((MenuPanel) menuPanel).getViewBooksButton().addActionListener(mgmgt.getShowViewBooksWindowAction());
        ((MenuPanel) menuPanel).getIssueBookButton().addActionListener(mgmgt.getShowIssueBookWindowAction());
        ((MenuPanel) menuPanel).getReturnBookButton().addActionListener(mgmgt.getShowReturnBookWindowAction());
    }

    @Override
    public JPanel getView() {
        return menuPanel;
    }
}