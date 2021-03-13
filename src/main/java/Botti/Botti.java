package Botti;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Botti {

    public static void launchBot(String token) throws Exception {
        //Luodaan JDABuilderi ja annetaan sille tokeni
        JDABuilder jdabuilder = JDABuilder.createDefault(token);

        //JDA jda;
        BotEventListeners botEvents = new BotEventListeners();
        UnicaMenuEventListener safka = new UnicaMenuEventListener();

        jdabuilder.addEventListeners(botEvents,safka);


        try {
            JDA jda = jdabuilder.build();
        } catch (LoginException e){
            //e.printStackTrace();
            throw new Exception("Huah");
        }
    }

}
