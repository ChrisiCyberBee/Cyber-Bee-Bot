package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class essen extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup e12")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986739709810212954/Essens-Ecke.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage("***:stuffed_flatbread: |Willkommen bei der Essens Ecke. Hier dreht sich alles um leckeres Essen.***").queue();



        }
    }
}

