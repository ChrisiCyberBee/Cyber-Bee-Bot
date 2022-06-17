package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class fn extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup p2")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/987113728652738570/Fortnite_1.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage("*** :video_game:   |Willkommen bei im Fortnite Chat . Hier kannst alles rund um Fortnite schreiben***").queue();



        }
    }
}



