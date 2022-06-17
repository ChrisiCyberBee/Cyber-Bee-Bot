package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class zählen  extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup e9")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986737809782079528/Zahlen-Ecke.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage("***:first_place: | Willkomen im Zählen Ecke  Chat. Hier kannst du wenn du Langeweile hast  oder Bock zu Zählen 1,2,3 usw tue es hier***").queue();



        }
    }
}

