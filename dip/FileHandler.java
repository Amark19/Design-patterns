import java.io.*;

class FileDataReader implements DataReader {
    private final String filePath;

    public FileDataReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readData() throws IOException {
        StringBuilder inputString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                inputString.append(aLine);
            }
        }
        return inputString.toString();
    }
}

class FileDataWriter implements DataWriter {
    private final String filePath;

    public FileDataWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeData(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }
}