package botti;

import jsonparse.JSONMapper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Eventtien kuunteluluokka
 * @author Valtteri Ingman & Jani Uotinen
 */
public class UnicaMenuEventListener extends ListenerAdapter {

    ArrayList<String> ruokalat =  new ArrayList<String>(Arrays.asList("Yliopiston kampus" ,"   !assari", "   !macciavelli", "   !galilei", "   !kaara","Kupittaan kampus", "   !dental", "   !delipharma", "   !delica", "   !linus","   !kisälli","Linnankadun taidekampus","   !sigyn", "   !muusa","Muut","   !ruokakello", "   !kaivomestari", "   !fabrik", "   !piccumaccia"));

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }

    }

}