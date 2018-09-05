import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Komyshenets on 05.09.2018.
 */
public class XmlFileWriter {
    private int maxElements;
    private int count;
    private List<File> files;
    private File currentFile;
    private FileWriter writer;
    private TableXMLRecord currentElement;
    private String title;

    public XmlFileWriter(int maxElements, String title) throws IOException {
        this.maxElements = maxElements;
        this.title = title;
        createNewFile();
    }


    public void addElement(TableXMLRecord tableXMLRecord) throws IOException {
//        if (isChildElement(tableXMLRecord)) {
//            this.currentElement.addIn(tableXMLRecord);

//        } else {
        count++;
        writer.append(writeRow(tableXMLRecord));
        if (isLastRecordInFile()) {
            closeFile();
            createNewFile();
        }
//        }
    }

    private boolean isChildElement(TableXMLRecord tableXMLRecord) {
        return false;
    }


    private boolean isLastRecordInFile() {
        return count % maxElements == 0;
    }

    public List getXMLFiles() throws IOException {
        closeFile();
        return files;
    }


    private void createNewFile() throws IOException {
        this.currentFile = new File("");
        this.files.add(currentFile);
        this.writer = new FileWriter(currentFile);
        this.writer.write(writeHeader());
    }


    private void closeFile() throws IOException {
        writer.append(writeFooter());
        writer.flush();
        writer.close();
    }

    private String writeHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("text header");
        stringBuffer.append("text title");
        return stringBuffer.toString();
    }

    private String writeRow(TableXMLRecord tableXMLRecord) {
        return tableXMLRecord.toString();
    }

    private String writeFooter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("footer");
        return stringBuffer.toString();
    }
}
