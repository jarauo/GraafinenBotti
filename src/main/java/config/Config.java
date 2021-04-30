package config;

import java.util.ArrayList;

/**
 * Structure class for Jackson JSON parsing. Specifically made for cfg.json file.
 * @author Jani Uotinen
 */
public class Config {
    String prefix;
    String toinen;


    public String getPrefix() {
        return this.prefix;
    }
    public void setPrefix(String newPrefix) {
        this.prefix = newPrefix;
    }
    public String getToinen() {return this.toinen;}
    public void setToinen(String newToinen){
        this.toinen = newToinen;
    }
}
