package Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ban extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!ban.")) {
            System.out.println("Nachricht !ban");
            ereignis.getChannel().sendTyping().queue();

            if (ereignis.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {

                Member mitglied = ereignis.getMessage().getMentionedMembers().get(0);

                mitglied.ban(3).queue();

            }

        }

    }
}