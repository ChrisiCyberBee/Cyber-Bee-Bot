package Commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!kick.")) {
            System.out.println("Nachricht !kick");

            if (ereignis.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {
                ereignis.getChannel().sendTyping().queue();

                Member mitglied = ereignis.getMessage().getMentionedMembers().get(0);

                mitglied.kick("sie werden von einem Teammitglied mit dem Grund kontaktiert innerhalb 24h. ").queue();


            }
        }
    }
}
