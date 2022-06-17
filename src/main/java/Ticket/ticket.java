package Ticket;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ticket extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!ticket")) {
            String roles = String.valueOf(ereignis.getMember().getRoles());
            if (roles.contains("Admin") || roles.contains("Moderatoren")) {

                EmbedBuilder Einbettung = new EmbedBuilder();
                Einbettung.setColor(0xffa900);
                Einbettung.setTitle("Ticket Support");
                Einbettung.setDescription("Klicke hier auf den Knopf um ein Ticket zu öffnen. Dies ist noch ein Test und dies funktionier auch nur wenn der Bot Online ist da sich der Bot noch weiter in Entwicklung befindet.");
                Einbettung.setThumbnail("https://media.discordapp.net/attachments/956658893273038898/978655945578143814/8485-discord-employee.png?width=110&height=115");

                ereignis.getChannel().sendMessageEmbeds(Einbettung.build()).setActionRow(Button.secondary("Ticket Öffnen!","Ticket hier erstellen!")).queue();



            }

        }

    }
}