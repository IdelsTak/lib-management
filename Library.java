import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Library {

    private final Connection connection;

    public Library(Connection connection) {
        this.connection = connection;
    }

    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();

        try ( Statement stmt = connection.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM books");) {
            while (rs.next()) {
                String id = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String status = rs.getString(4);

                result.add(new Book(id, title, author, status));
            }
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
        }

        return Collections.unmodifiableList(result);
    }

    public Book getBook(String bookId) {
        return this.getBooks()
                .stream()
                .filter(b -> (bookId == null ? b.getId() == null : bookId.equals(b.getId())))
                .findFirst().orElse(null);
    }

    public void addBook(Book book) {
        try ( PreparedStatement ps = connection.prepareStatement("INSERT INTO books (id, title, author, status) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getStatus());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
        }
    }

    public void removeBook(String bookId) {
        try ( PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id = ?")) {
            ps.setString(1, bookId);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
        }
    }

    public void issueBook(Lend lend) {
        boolean notIssued = this.getLends().stream().noneMatch(lnd -> Objects.equals(lnd, lend));

        if (notIssued) {
            try ( PreparedStatement ps = connection.prepareStatement("INSERT INTO lends (student, bookId) VALUES (?, ?)")) {
                ps.setString(1, lend.getStudent());
                ps.setString(2, lend.getBook().getId());

                int updatedRows = ps.executeUpdate();

                if (updatedRows == 1) {
                    this.updateBookStatus(lend.getBook(), "issued");
                }
            } catch (SQLException ex) {
                System.out.println(SQLExceptionUtil.unwrap(ex));
            }
        }
    }

    public void returnBook(Lend lend) {
        boolean issued = this.getLends().stream().anyMatch(lnd -> Objects.equals(lnd, lend));

        if (issued) {
            try ( PreparedStatement ps = connection.prepareStatement("DELETE FROM lends WHERE student = ? AND bookId = ?")) {
                ps.setString(1, lend.getStudent());
                ps.setString(2, lend.getBook().getId());

                int updatedRows = ps.executeUpdate();

                if (updatedRows == 1) {
                    this.updateBookStatus(lend.getBook(), "avail");
                }
            } catch (SQLException ex) {
                System.out.println(SQLExceptionUtil.unwrap(ex));
            }
        }
    }

    public List<Lend> getLends() {
        List<Lend> result = new ArrayList<>();

        try ( Statement stmt = connection.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM lends");) {
            while (rs.next()) {
                String student = rs.getString(1);
                String bookId = rs.getString(2);

                Book book = this.getBook(bookId);

                if (book != null && book.getStatus().equals("issued")) {
                    result.add(new Lend(student, book));
                }
            }
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
        }

        return Collections.unmodifiableList(result);
    }

    public Lend getLend(String bookId) {
        return this.getLends()
                .stream()
                .filter(lend -> (bookId == null ? lend.getBook().getId() == null : bookId.equals(lend.getBook().getId())))
                .findFirst().orElse(null);
    }

    private void updateBookStatus(Book book, String status) {
        try ( PreparedStatement ps = connection.prepareStatement("UPDATE books SET status = ? WHERE id = ?")) {
            ps.setString(1, status);
            ps.setString(2, book.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
        }
    }
}
