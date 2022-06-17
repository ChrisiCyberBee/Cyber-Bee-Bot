package Ticket;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;


import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;

public class TicketKnopf extends ListenerAdapter {


    public void onButtonInteraction(ButtonInteractionEvent ereignis){

        ereignis.deferEdit().queue();

        if (ereignis.getButton().getId().equals("Ticket Öffnen!")) {

            String roles = String.valueOf(ereignis.getMember().getRoles());

            if (roles.contains("Ticketsperre")){

                int min = 100;
                int max= 99999;
                int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                Guild guild = ereignis.getGuild();
                EmbedBuilder Einbettung = new EmbedBuilder();

                Einbettung.setColor(0xffa900);
                Einbettung.setTitle(ereignis.getUser().getName() + "´s Ticket");
                Einbettung.setDescription("Ein Teammitglied wird sich in naher Zukunft um dich kümmern. Bitte habe etwas gedult!");

                guild.createTextChannel("ticket_" + random_int, guild.getCategoryById("985928248972173343"))
                        .addPermissionOverride(ereignis.getMember(), EnumSet.of(Permission.VIEW_CHANNEL),null)
                        .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                        .addPermissionOverride(guild.getRoleById("955105439136251942"), EnumSet.of(Permission.VIEW_CHANNEL),null)
                        .addPermissionOverride(guild.getRoleById("955105439136251943"), EnumSet.of(Permission.VIEW_CHANNEL),null)
                        .complete().sendMessageEmbeds(Einbettung.build()).setActionRow(closeKnopf(), claimKnopf()).queue();

                EmbedBuilder Team = new EmbedBuilder();

                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                Date date = new Date();

                Team.setColor(Color.red);
                Team.setTitle("Ticket System");
                Team.addField("Ticket erstellt von", ereignis.getMember().getAsMention(), true);
                Team.addField("Tickt erstellt am:", formatter.format(date), true);

                guild.getTextChannelById("956658893273038898").sendMessageEmbeds(Team.build()).queue();
            }else {

                EmbedBuilder Sperre = new EmbedBuilder()
                        .setColor(0xffa900)
                        .setTitle("Ticket System")
                        .setDescription("Du hast eine Ticketsperre!");
                ereignis.getUser().openPrivateChannel().complete().sendMessageEmbeds(Sperre.build()).queue();



            }


        }else if (ereignis.getButton().getId().equals("closeKnopf")) {

            String roles = String.valueOf(ereignis.getMember().getRoles());

            if (roles.contains("Admin") || roles.contains("Support") || roles.contains("Moderatoren")) {

                ereignis.getInteraction().getChannel().delete().queue();
            }

        }else if (ereignis.getButton().getId().equals("claimKnopf")) {
            PermissionOverride permissionOverride = null;
            if (ereignis.getInteraction().getMember().hasPermission(Permission.KICK_MEMBERS)) {
                TextChannel channel = ereignis.getTextChannel();
                ereignis.getInteraction().getMessage().delete().queue();
                EmbedBuilder embed = new EmbedBuilder()
                        .setColor(0xffa900)
                        .setTitle("Ticket System")
                        .setDescription(ereignis.getInteraction().getUser().getAsMention() + "hat das Ticket geclaimt");
                channel.sendMessageEmbeds(embed.build()).setActionRow(closeKnopf()).queue();
                permissionOverride = channel.getPermissionOverride(ereignis.getMember());
                if (permissionOverride == null){
                    //channel.getPermissionOverride(ereignis.getMember()).getRole().hasPermission(Permission.VIEW_CHANNEL);
                    channel.upsertPermissionOverride(ereignis.getMember()).setAllowed(Permission.VIEW_CHANNEL).queue();
                } else {

                    permissionOverride.getManager().setAllowed(Permission.VIEW_CHANNEL).queue();
                }
                PermissionOverride permissionOverride2 = channel.getPermissionOverride(ereignis.getGuild().getRoleById("955105439136251942"));
                if (permissionOverride2 == null) {
                    channel.upsertPermissionOverride(ereignis.getGuild().getRoleById("955105439136251942")).setDenied(Permission.VIEW_CHANNEL).queue();
                }else {
                    permissionOverride2.getManager().setDenied(Permission.VIEW_CHANNEL).queue();
                }

            }

        }

    }

    private Button closeKnopf() {
        return Button.danger("closeKnopf", "Schließen des Tickets");

    }

    private Button claimKnopf() {

        return Button.success("claimKnopf", "Claimen des Tickets");

    }
}
