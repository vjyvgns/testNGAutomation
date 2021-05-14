package main.java.utils;

import java.io.*;
import java.util.Properties;

public class propertiesReader {

    static Properties properties;
    public static void loadData() throws IOException {
        File f = new File(System.getProperty("user.dir") + "/src/test/java/testData/config.properties");
        FileInputStream fis = new FileInputStream(f);
        properties = new Properties();
        properties.load(fis);
    }

    public static String getObject(String Data) throws IOException {
        loadData();
        String data = properties.getProperty(Data);
        return data;
    }
}
