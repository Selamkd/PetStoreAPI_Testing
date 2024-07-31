package com.sparta.test_petstore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = AppConfig.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IOException("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUri() {
        return properties.getProperty("base_api_url");
    }

    public static String getPetByIdPath(){
        return properties.getProperty("PET_BY_ID");
    }
    
    public static String getPetBodyPath(){
        return properties.getProperty("PET_BODY");
    }



}
