package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class Verify extends ListenerAdapter {

    public void  onMessageReceived (MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup verify")) {

            if (ereignis.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                ereignis.getChannel().sendTyping().queue();

                EmbedBuilder bauplan = new EmbedBuilder();
                bauplan.setTitle("Verifieziere dich bitte hier!");
                bauplan.setImage("https://cdn.discordapp.com/attachments/956658893273038898/984887259172065290/standard_3.gif");
                bauplan.setColor(0x42b580);
                bauplan.setDescription("Verhalte dich bitte immer höflich und respecktvoll und halte dich an all unsere Regeln");
                bauplan.addField("Wie kann ich mich Verifizieren?", "Verifizieren kannst du dich indem du Auf den Knopf unter dieser Nachricht klickst.",true);

                Button Knopf = Button.secondary("verifizieren", "Hiermit kannst du dich Verifizieren!");

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(Knopf).queue();


            }


        }
    }
    public void onButtonInteraction (ButtonInteractionEvent ereignis){

        if (ereignis.getButton().getId().equals("verifizieren")) {

            Role verifyRole = ereignis.getGuild().getRoleById("980561406669750334");

            ereignis.getGuild().removeRoleFromMember(ereignis.getMember(), verifyRole).queue();
            ereignis.reply("Du bist nun Verifieziert, Viel Spaß!").setEphemeral(true).queue();

        }

    }
}
