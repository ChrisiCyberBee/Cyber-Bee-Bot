package Chats;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Hilfmir  extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup c4")) {

            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986502450800381982/Hilf-Mir.png");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            ereignis.getChannel().sendMessage("***:envelope_with_arrow:  |Willkommen im Hilf Mir Chat. Wenn Sie Hilfe benötigen, kontaktieren Sie uns hier und wir versuchen ihnen zu Helfen.*** Bei Fragen an das Team /open oder auf die gepinnte Nachricht.").queue();



        }
    }
}

