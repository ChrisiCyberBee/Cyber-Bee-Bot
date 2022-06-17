package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Support  extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup c3")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986502450561318913/Discord--Server-Support.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage(" ***:pencil: |Willkommen beim Discord- Server Support  Chat. Wenn Sie ein Problem mit Spielern haben oder jemand gegen eine Regel verstoßen hat, kontaktieren Sie uns hier.*** Bei vertraulichen Dinge Bitte /open oder der Angepinnte Kommentar.").queue();



        }
    }
}

