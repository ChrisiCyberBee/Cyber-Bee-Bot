package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Rollenauswahl extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup rollen")) {
            System.out.println("Rollen kommen");

            if (ereignis.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                ereignis.getChannel().sendTyping().queue();

                EmbedBuilder bild = new EmbedBuilder();

                bild.setImage("https://cdn.discordapp.com/attachments/956658893273038898/984842643831939112/Gamingrollen_3.png");
                bild.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bild.build()).queue();

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setTitle("Wähle deine Rollen aus!");
                bauplan.setThumbnail("https://cdn.discordapp.com/attachments/956658893273038898/985519205107515493/1778568.png");
                bauplan.setColor(0xffa900);
                bauplan.setDescription("Klicke auf das Menü unter dieser Nachricht, um mit der Auswahl zu beginnen!");
                bauplan.addField(":performing_arts: Was sind Rollen?", "Deine Rollenauswahl verrät anderen Personen ein paar Informationen über dich.", true);
                bauplan.addField(":bell: Was sind Benachrichtigungen?", "Benachrichtigungen machen dich auf bestimmte Ereignisse aufmerksam!", true);
                bauplan.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

                EmbedBuilder bedienfeld = new EmbedBuilder();

                bedienfeld.setTitle("Klicke hier um deine Rollen auszuwählen!");
                bedienfeld.setThumbnail("https://cdn.discordapp.com/attachments/955121034158309426/984858377156964352/cursor.png");
                bedienfeld.setDescription(":grey_question: Klicke auf das Menü unter dieser Nachricht, um deine Rollen auszuwählen.");
                bedienfeld.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");
                bedienfeld.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bedienfeld.build()).queue();




            }
        }
    }
}

