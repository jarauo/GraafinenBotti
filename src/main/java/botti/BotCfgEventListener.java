package botti;

import config.BotConfiguration;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Event listener class for general bot use. For example cfg edit.
 * @author Jani Uotinen
 */
public class BotCfgEventListener extends ListenerAdapter {
    String command,prefix,value;
    BotConfiguration botconfig = new BotConfiguration();

    /**
     * Method for reacting a message.
     * @author Jani Uotinen
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        /**
         * Checks that the message sender is not a Bot. Otherwise will possibly make an infinite message loop with
         * itself or other bots.
         */
        if (event.getAuthor().isBot()) {
            return;
        }

        //Save the message to a variable.
        String message = event.getMessage().getContentRaw();

        //Checks if the message has a valid prefix and splits it.
        if (botconfig.getPrefix().equals(message.substring(0,1))) {
            splitCommand(message);
        }

        /**
         * Checks if the command is valid.
         */
        if (botconfig.checkLegalCommand(command)) {
            //processBotConfigCommand(event,value);
            if (command.equals("prefix")) {
                botconfig.changePrefix(command,value);
            }
            if (command.equals("toinen")) {
                event.getChannel().sendMessage(botconfig.printCommandList()).queue();
            }

        }

        //Clear commands at the end.
        clearCommand();
    }

    /**
     * Splits and sets given command to a class variable.
     * @author Jani Uotinen
     */
    public void splitCommand(String message) {
        System.out.println("Message: "+message);
        String[] splittedCommand = message.split(" ");
        System.out.println("splitted length "+splittedCommand.length);

        if (splittedCommand.length > 1) {
            this.prefix = splittedCommand[0].substring(0,1);
            this.command = splittedCommand[0].substring(1);
            this.value = splittedCommand[1];
            System.out.println("BotEventListeners: All 3 values saved.");
        } else {
            this.prefix = splittedCommand[0].substring(0,1);
            this.command = splittedCommand[0].substring(1);
            this.value = "";
            System.out.println("BotEventListeners: 2 values saved.");
        }

        if (command.isEmpty()) {
            clearCommand();
            System.out.println("BotEventListeners: No values saved.");
        }

    }

    /**
     * Clears the class variable for splitted command.
     * @author Jani Uotinen
     */
    public void clearCommand() {
        this.prefix = "";
        this.command = "";
        this.value = "";
    }

    /**
     * Processes the change prefix command.
     * @author Jani Uotinen
     */
    public void processBotConfigCommand(MessageReceivedEvent event,String command) {
        botconfig.changePrefix(command,value);
        event.getChannel().sendMessage("New prefix is: "+botconfig.getPrefix()).queue();
    }

}

