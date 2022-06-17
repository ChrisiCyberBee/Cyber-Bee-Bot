package Commands;

import com.sun.tools.javac.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Command extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        String[] args = ereignis.getMessage().getContentStripped().split(" ");




        }

    }


