package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NachrichtenReation extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.isFromGuild()) {

            if (ereignis.getMessage().getContentStripped().equals("Hilfe")) {

                String username = ereignis.getAuthor().getName();

                ereignis.getChannel().sendMessage("Brauchst du Hilfe " + username + "? Dann kannst du zu https://discord.com/channels/955105439136251934/955105439555649599 oder zu https://discord.com/channels/955105439136251934/955105439555649600").queue();
                ereignis.getChannel().sendTyping().queue();

            } else if (ereignis.getMessage().getContentStripped().equals("!hilfe")){

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setTitle("Befehlsliste zu ~Cyber Bee Bot~");
                bauplan.setDescription("In dieser Einbettung findest du alle Infos über diesen Bot welcher mit Tutorials und eigener Erfahrung erstellt wurde. Dieser Bot würd sehr oft geupdatet um neue Funktionen mit sich zu Bringen. Dieser Bot Hilft & Unterstützt bei der Verwaltung des Servers.");
                bauplan.setColor(0xffa900);

                bauplan.setImage("https://cdn.discordapp.com/attachments/956658893273038898/976579181133578331/static.png");

                bauplan.setFooter("~Stand vom 18.05.22~");
                bauplan.addField("Infomationen zum Bot", "Text", true);
                bauplan.addField("Befehle für den Bot", "!hilfe zeigt dir Infos zum Bot dir an. \n!profil @... zeigt dir Infomationen zu einem Nutzer an. \n !serverinfo zeigt dir ein paar Serverinfos an.", false);

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

            }

        }

    }
}
