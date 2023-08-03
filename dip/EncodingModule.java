package solid.live.dip;


import net.iharder.Base64;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */

interface DataReader {
    String readData() throws IOException;
}

interface DataWriter {
    void writeData(String data) throws IOException;
}

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


public class EncodingModule {

    private DataReader reader;
    private DataWriter writer;

    EncodingModule(DataReader reader, DataWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void encodeWithFiles() {
        try {
            String inputData = reader.readData();
            String encodedData = Base64.encodeBytes(inputData.getBytes());
            writer.writeData(encodedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeBasedOnNetworkAndDatabase() {
        try {
            String inputData = reader.readData();
            String encodedData = Base64.encodeBytes(inputData.getBytes());
            MyDatabase database = new MyDatabase();
            database.write(encodedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

