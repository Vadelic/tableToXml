import java.sql.ResultSet;

/**
 * Created by Komyshenets on 05.09.2018.
 */
public class TableXMLRecord {
    private String title;
    int level = 1;

    private TableXMLRecord[] chid;

    public TableXMLRecord(String title, int i) {

    }

    public void addValues(ResultSet cursor, String[] columNames) {


    }

    public void addIn(TableXMLRecord tableXMLRecord) {
        for (TableXMLRecord xmlRecord : chid) {
            if (isChildElement(tableXMLRecord))
                xmlRecord.addIn(tableXMLRecord);

        }

    }

    private boolean isChildElement(TableXMLRecord tableXMLRecord) {
        return false;
    }

    private String writeHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("<%s>", title));
        return stringBuffer.toString();
    }

    private String writeRow(TableXMLRecord tableXMLRecord) {
        return tableXMLRecord.toString();
    }

    private String writeFooter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("</%s>", title));
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(writeHeader());
        stringBuffer.append(writeRow(this));
        stringBuffer.append(writeFooter());
        return super.toString();
    }
}
