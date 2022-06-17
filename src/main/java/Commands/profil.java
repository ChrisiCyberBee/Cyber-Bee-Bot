package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class profil extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!profil")) {
            System.out.println("Nachricht !view");

            Member mitglied = ereignis.getMessage().getMentionedMembers().get(0);
            ereignis.getChannel().sendTyping().queue();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Nutzerinfomation zu " + mitglied.getEffectiveName());
            bauplan.addField("Nutzer-ID", mitglied.getId(),true);
            bauplan.addField("Discord Name", mitglied.getUser().getAsTag(),true);
            bauplan.addField("Auf dem Server seit:", mitglied.getTimeJoined().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), false);
            bauplan.addField("Hat sein Account erstellt am:", mitglied.getTimeCreated().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), false);
            bauplan.addField("Rollenanzahl",String.valueOf(mitglied.getRoles().stream().count()),true);
            bauplan.setColor(0xffa900);
            bauplan.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");


            if (mitglied.getNickname() != null) {
                bauplan.addField("Nickname", mitglied.getNickname(), true);
            }

            mitglied.getOnlineStatus();
            bauplan.setThumbnail(mitglied.getEffectiveAvatarUrl());

            Button profileButton = Button.link(mitglied.getEffectiveAvatarUrl() , "Profilbild abrufen");

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(profileButton).queue();

        }

        //builder.enableCache(CacheFlag.CLIENT_STATUS);


    }

}