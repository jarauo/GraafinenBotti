package jsonparse;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * JSONMapper class to parse different JSON structures into Java classes.
 * @ Jani Uotinen
 */
public class JSONMapper {

    /**
     * Method for parsing cfg.json file. Uses Config.class.
     * @author Jani Uotinen
     */
    public static Config cfgParser() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Config config = mapper.readValue(new File("src/main/resources/cfg/cfg.json"), Config.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while parsing cfg file.");
            return null;
        }

    }

    /**
     * Metodi unica-ravintoloiden parseemiseen.
     */
    public static String unicaParser(String jsonURL) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Restaurant ruoka = mapper.readValue(new URL(jsonURL), Restaurant.class);
            //System.out.println(ruoka);
            return ruoka.toString();
            //return "Testi";
        } catch (IOException e) {
            e.printStackTrace();
            return "Sivustoa ei ole saatavilla";
        }
    }
}
