package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Befehle extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup befehle")) {
            System.out.println("Befehle kommen");

            if (ereignis.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                ereignis.getChannel().sendTyping().queue();

                EmbedBuilder bild = new EmbedBuilder();

                bild.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986502291219677204/Befehle-und-Befehlsliste.png");
                bild.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bild.build()).queue();

                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setTitle(":wrench: Bot Commands auf Game Time :video_game: by Cyber Bee´s :bee: ");
                bauplan.setThumbnail("https://cdn-icons-png.flaticon.com/512/4403/4403384.png");
                bauplan.setColor(0xffa900);
                bauplan.setDescription("In diesem Kanal findest du alle wichtigen Dinge, die du wissen musst, um unsere Bots bedienen zu können und eine Befehlsliste mit Befehlen.");
                bauplan.addField("", "Klicke dazu einfach auf das Menü unter dieser Nachricht.", true);
                bauplan.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

                EmbedBuilder bedienfeld = new EmbedBuilder();

                bedienfeld.setTitle(":warning:  Alle Nachrichten werden nach 45 Sekunden gelöscht!");
                bedienfeld.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");
                bedienfeld.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bedienfeld.build()).queue();




            }
        }
    }
}
