import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import net.ucanaccess.jdbc.UcanaccessSQLException;

public class MsAccessDatasource {

    private Connection connection;

    private MsAccessDatasource() {
    }

    public static MsAccessDatasource getInstance() {
        return MySQLConnectionHolder.INSTANCE;
    }

    public Connection getConnection() {
        if (connection == null) {
            connection = this.createConnection();
        }

        return connection;
    }

    private Connection createConnection() {
        try {
            File dbFile = this.getDatabaseFile();
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + dbFile + ";newdatabaseversion=V2010");

            this.createTablesIfNotExist(conn);

            return conn;
        } catch (SQLException ex) {
            System.out.println(SQLExceptionUtil.unwrap(ex));
            throw new RuntimeException(ex);
        }
    }

    private void createTablesIfNotExist(Connection conn) throws SQLException {
        String createBooksTableSql = ""
                + "CREATE TABLE books ( "
                + "  id VARCHAR(10) NOT NULL, "
                + "  title VARCHAR(20) NOT NULL, "
                + "  author VARCHAR(20) NOT NULL, "
                + "  status VARCHAR(10) NOT NULL, "
                + "  PRIMARY KEY (id) "
                + ");";
        String createLendsTableSql = ""
                + "CREATE TABLE lends ( "
                + "  student VARCHAR (20) NOT NULL, "
                + "  bookId VARCHAR (10) NOT NULL, "
                + "  PRIMARY KEY (student, bookId), "
                + "  CONSTRAINT fk_book FOREIGN KEY (bookId) REFERENCES books(id) "
                + ");";

        try ( Statement s = conn.createStatement()) {
            conn.setAutoCommit(false);

            s.addBatch(createBooksTableSql);
            s.addBatch(createLendsTableSql);

            s.executeBatch();
            conn.commit();
        } catch (UcanaccessSQLException ex) {
            if (ex.getMessage().indexOf("object name already exists:") > 0) {
                System.out.println("INFO: Table already exists.");
            } else {
                throw ex;
            }
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private File getDatabaseFile() {
        return new File((System.getProperty("user.dir") + File.separator + "LibSys.accdb"));
    }

    private static class MySQLConnectionHolder {

        private static final MsAccessDatasource INSTANCE = new MsAccessDatasource();
    }
}
