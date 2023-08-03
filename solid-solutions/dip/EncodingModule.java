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

public class EncodingModule {


    public static void readEncodeAndWrite(DataReader reader, DataWriter writer) {
        String inputData = reader.readData();
        String encodedData = Base64.encodeBytes(inputData.getBytes());
        writer.writeData(encodedData);
    }
}


