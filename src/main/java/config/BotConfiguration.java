package config;

import jsonparse.Config;
import jsonparse.JSONMapper;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Luokka cfg-filujen arvojen käsittelemiseen ohjelmassa.
 * @author Jani Uotinen
 */
public class BotConfiguration{
    private String prefix;
    private Config config;

    public BotConfiguration() {
        this.config = JSONMapper.cfgParser();
        this.prefix = config.getPrefix();
    }

    public String getPrefix() {
        return this.prefix;
    }
    /*
    public HashMap<String,String> getConfig() {
        return this.config;
    }
     */
}
