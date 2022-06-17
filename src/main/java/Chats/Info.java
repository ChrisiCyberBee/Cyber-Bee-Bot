package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info  extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup c5")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986502450213163038/Infomationen.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage("***:newspaper2: |Willkommen bei Infomationen , Hier gibt es immer mal etwas zu erfahren.***").queue();



        }
    }
}

