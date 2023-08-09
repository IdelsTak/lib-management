import java.sql.SQLException;

import static java.lang.System.lineSeparator;

public class SQLExceptionUtil {

    private SQLExceptionUtil() {
    }

    /**
     * Maps all the details of an SQLException chain to text.
     * <p>
     * Details included are SQL State, Error code, Exception message.
     *
     * @param sqle the SQLException from which to extract details.
     */
    public static String unwrap(SQLException sqle) {
        StringBuilder sb = new StringBuilder();
        // Unwraps the entire exception chain
        // to unveil the real cause of the Exception
        while (sqle != null) {
            sb.append(lineSeparator()).append("----- SQLException -----").append(lineSeparator());
            sb.append("  SQL State:  ").append(sqle.getSQLState()).append(lineSeparator());
            sb.append("  Error Code: ").append(sqle.getErrorCode()).append(lineSeparator());
            sb.append("  Message:    ").append(sqle.getMessage()).append(lineSeparator());
            sqle = sqle.getNextException();
        }
        return sb.toString();
    }
}