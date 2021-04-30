package config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonparse.JSONMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to manage cfg.json file. At the moment it parses the cfg.json file in two different ways. Into a Config class
 * and into a HashMap<String,String>.
 * @author Jani Uotinen
 */
public class BotConfiguration{
    private Config config;
    private HashMap<String,String> commandList;


    public BotConfiguration() {
        this.config = JSONMapper.cfgParser();
        makeCommandList();
    }

    /**
     * Creates the cfg.json file as a HashMap<String,String>
     */
    public void makeCommandList() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.commandList = mapper.readValue(new File("src/main/resources/cfg/cfg.json"),new TypeReference<HashMap<String,String>>(){});
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Error making commandList.");
        }
    }

    /**
     * Returns current prefix.
     */
    public String getPrefix() {
        return this.config.getPrefix();
    }

    /**
     * Checks if the config HashMap contains a certain value.
     */
    public boolean checkLegalCommand(String command) {
        return this.commandList.containsKey(command);
    }

    /**
     * A method for changing current prefix.
     */
    public void changePrefix(String command,String value) {
        if (EditConfig.checkLegalPrefix(value)) {
            this.config.setPrefix(value);
            writeToFile();
            System.out.println("Prefix switched.");
            makeCommandList();
        }
    }

    /**
     * Writes the cfg.json file with current values.
     */
    public void writeToFile(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/cfg/cfg.json"),this.config);
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("BotConfiguration: Writing to cfg.json failed.");
        } finally {

        }

    }

    /**
     * Returns the keys and values in commandlist.
     */
    public StringBuilder printCommandList() {
        StringBuilder sb = new StringBuilder();
        for (String key : this.commandList.keySet()) {
            //System.out.printf("Key: "+key+" | Value: "+this.commandList.get(key)+"\n");
            sb.append("Key: "+key+" | Value: "+this.commandList.get(key)+"\n");
        }
        return sb;
    }

}
