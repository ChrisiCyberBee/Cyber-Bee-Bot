package Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Timeout extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!stumm")) {
            System.out.println("Nachricht !stumm");

            if (ereignis.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {
                ereignis.getChannel().sendTyping().queue();

            Member mitglied = ereignis.getMessage().getMentionedMembers().get(0);

            Role rolle = ereignis.getGuild().getRoleById("967174954783236196");

            ereignis.getChannel().sendMessage("wurde stumm geschaltet").queue();

            }

        }

    }
}

