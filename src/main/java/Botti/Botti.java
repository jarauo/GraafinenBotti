package Botti;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Botti {

    public static void launchBot() throws Exception {
        //Luodaan JDABuilderi ja annetaan sille tokeni
        JDABuilder jdabuilder = JDABuilder.createDefault("syötä tokeni tähän");

        JDA jda;
        BotEventListeners botEvents = new BotEventListeners();
        jdabuilder.addEventListeners(botEvents);

        try {
            jda = jdabuilder.build();
        } catch (LoginException e){
            e.printStackTrace();
        }
    }
}
