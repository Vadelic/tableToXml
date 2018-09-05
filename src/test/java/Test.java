import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Komyshenets on 05.09.2018.
 */
public class Test {


    public static void main(String[] args) throws SQLException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        ResultSet cursor = connectionPool.cursor("select * from tableview");

        String[] columnNames = getColumns(cursor.getMetaData());

        XmlFileWriter headXml = new XmlFileWriter(2, "Реестр");
        int count = 0;
        while (cursor.next()) {
            TableXMLRecord record = new TableXMLRecord("Row", ++count);
            record.addValues(cursor, columnNames);

            headXml.addElement(record);
        }
        headXml.getXMLFiles();
    }

    private static String[] getColumns(ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        return null;
    }

}
