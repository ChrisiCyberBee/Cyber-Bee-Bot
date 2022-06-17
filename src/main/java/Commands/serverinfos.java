package Commands;

import com.sun.tools.javac.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


public class serverinfos extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {
        if (ereignis.getMessage().getContentStripped().equals("!serverinfo")){
            ereignis.getChannel().sendMessageEmbeds(serverinfo(ereignis.getGuild()).build()).queue();
            ereignis.getChannel().sendTyping().queue();

        }

    }

    private static EmbedBuilder serverinfo(Guild guild) {
        EmbedBuilder builder = new EmbedBuilder();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        OffsetDateTime date =guild.getTimeCreated();
        String formatted = df.format(date);

        builder.setColor(0xffa900);
        builder.setTitle(guild.getName());
        builder.setDescription("Infomationen zum Server");
        builder.addField(" :busts_in_silhouette: Mitglieder:", String.valueOf(guild.getMemberCount()),true);
        builder.addField(" :date: Erstellt am:", formatted,true);
        builder.addField(" :crown: Owner:",guild.getOwner().getUser().getName(), true);
        builder.addField(" :tada: Booster:",String.valueOf(guild.getBoostCount()),true);
        builder.addField(" :books: Kanäle:",String.valueOf(guild.getChannels().stream().count()),true);
        builder.addField(" :performing_arts: Rollenanzahl:",String.valueOf(guild.getRoles().stream().count()),true);
        builder.setThumbnail("https://images-ext-2.discordapp.net/external/QAsDawaMwKERqgQiQ2ihICS-5v8gx5G2brz5kUroN1c/%3Fsize%3D1024/https/cdn.discordapp.com/icons/955105439136251934/95f30546aa8ff58859d8d62e476ad523.png?width=482&height=482");
        builder.setFooter("Die angebenen Daten sind aktuell.");

        return builder;
    }

}
