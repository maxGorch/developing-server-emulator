package com.omsu.gorch825.httpserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private Configuration myCurrentConfiguration;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null)
            myConfigurationManager = new ConfigurationManager();
        return myConfigurationManager;
    }

    public void loadConfigurationFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader fileReader = new FileReader(filePath);
        myCurrentConfiguration = objectMapper.readValue(fileReader, Configuration.class);
    }

    public Configuration getCurrentConfiguration() {
        if (myCurrentConfiguration == null) {
            throw new RuntimeException("Настройки не загружены!");
        }
        return myCurrentConfiguration;
    }
}
