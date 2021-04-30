package config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class to edit cfg file. Read and write.
 * @author Jani Uotinen
 */
public class EditConfig {

    /**
     * Reads the cfg file and returns it as a HashMap.
     * @author Jani Uotinen
     */
    public static HashMap<String,String> readFromConfigurationFile() {
        HashMap<String,String> configuration = new HashMap<>();

        try {
            File inputFile = new File("src/main/resources/cfg/cfg.txt");
            Scanner fileReader = new Scanner(inputFile);

            //Goes through every line of the cfg file.
            while (fileReader.hasNextLine()) {
                String cfgLine = fileReader.nextLine(); //A line from cfg file.

                String[] cfgLineSplit = cfgLine.split("=="); //The line splitted with "==".

                configuration.put(cfgLineSplit[0],cfgLineSplit[1]); //Save the splitted line as a key and value.
            }
            //Closes the fileReader.
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("EditConfig Read: File not found.");
            e.printStackTrace();
        }
        return configuration;
    }

    /**
     * Ylikirjoittaa halutun kohdan cfg-filusta.
     * @author Jani Uotinen
     */
    public static void writeToConfigurationFile(String input) {
        //Haetaan olemassaoleva cfg-file.
        HashMap<String,String> originalConfiguration = readFromConfigurationFile();

        //Splitataan syötetty ylikirjoitettava rivi HashMapille sopivaksi avaimeksi ja arvoksi.
        String[] inputSplit = input.split("==");
        String key = inputSplit[0];
        System.out.println("key "+key);
        String value = inputSplit[1];
        System.out.println("value "+value);

        //Etsitään sopiva avain ja korvataan arvo uudelle syötetyllä arvolla.
        for (String keyString : originalConfiguration.keySet()) {
            if (keyString.equals(key)) {
                originalConfiguration.put(key,value);
            }
        }

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/cfg/cfg.txt"));

            for (String keyString : originalConfiguration.keySet()) {
                fileWriter.write(keyString+"=="+originalConfiguration.get(keyString)+"\n");
            }

            fileWriter.close();
        } catch (Exception e) {
            System.out.println("EditConfig Write: Error writing config.");
            e.printStackTrace();
        }
    }

    /**
     * Tarkistaa onko syötettävä prefix symboli kelvollinen.
     * @author Jani Uotinen
     */
    public static boolean checkLegalPrefix(String input) {
        String symbols = "*./!?,%&#-+";
        if (symbols.contains(input)) {
            return true;
        } else {
            return false;
        }
    }
}