package Willkomen;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Willkommen extends ListenerAdapter {

    public void onGuildMemberJoin (GuildMemberJoinEvent ereignis){

        User nutzer = ereignis.getUser();

        EmbedBuilder bauplan = new EmbedBuilder();
        bauplan.setTitle("Herzlich Willkommen");
        bauplan.setDescription(" Herzlich Willkommen auf **Game Time :video_game:  by Cyber Bee´s :bee: ** Danke das du gejoint bist, wir wünschen dir Viel Spaß auf unserem Server! Einladungslink: https://discord.gg/Z4dEvTrpCq ");
        bauplan.setImage("https://images-ext-2.discordapp.net/external/3WdzqQ22CYrcv49lQUMeprqtkg1acXqBXHKsLh771kY/https/cdn-longterm.mee6.xyz/plugins/welcome/images/955105439136251934/75dbc51d666ccffd2b481966d7eaddd7e2f0076098f45cffb6a15d27cd826abb.gif?width=421&height=54");

        nutzer.openPrivateChannel().complete().sendMessageEmbeds(bauplan.build()).queue();

        EmbedBuilder einbettung = new EmbedBuilder();
        einbettung.setTitle("Herzlich Willkommen");
        einbettung.setDescription(" Herzlich Willkommen <:Axoheart:955494001593708556>  auf **Game Time :video_game:  by Cyber Bee´s :bee: ** , wir wünschen dir Viel Spaß auf unserem Server! <:Axocute:955109148700323922> ");
        einbettung.setImage("https://images-ext-2.discordapp.net/external/3WdzqQ22CYrcv49lQUMeprqtkg1acXqBXHKsLh771kY/https/cdn-longterm.mee6.xyz/plugins/welcome/images/955105439136251934/75dbc51d666ccffd2b481966d7eaddd7e2f0076098f45cffb6a15d27cd826abb.gif?width=421&height=54");

        ereignis.getGuild().getTextChannelById("955105439555649603").sendMessageEmbeds(einbettung.build()).queue();


    }
}
