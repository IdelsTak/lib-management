import java.util.Objects;

public class Lend {

    private final String student;
    private final Book book;

    public Lend(String student, Book book) {
        this.student = student;
        this.book = new Book(book.getId(), book.getTitle(), book.getAuthor(), "issued");
    }

    public String getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.student);
        hash = 29 * hash + Objects.hashCode(this.book);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lend other = (Lend) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lend{");
        sb.append("student=").append(student);
        sb.append(", book=").append(book);
        sb.append('}');
        return sb.toString();
    }

}
