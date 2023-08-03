
import java.io.*;
import java.net.URL;

class NetworkDataReader implements DataReader {
    private final String url;

    public NetworkDataReader(String url) {
        this.url = url;
    }

    @Override
    public String readData() throws IOException {
        URL urlObj = new URL(url);
        try (InputStream in = urlObj.openStream();
             InputStreamReader reader = new InputStreamReader(in);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            StringBuilder inputString = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputString.append(line);
            }
            return inputString.toString();
        }
    }
}

class DataBaseWriter implements DataWriter {

    @Override
    public void writeData(String data) throws IOException {
        MyDatabase database = new MyDatabase();
        database.write(data);
    }
}