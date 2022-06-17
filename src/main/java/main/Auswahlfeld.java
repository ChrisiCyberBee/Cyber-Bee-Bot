package main;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;

public class Auswahlfeld extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!menü")) {
            ereignis.getChannel().sendMessage("Rollenauswahl").setActionRow().queue();
            {
                SelectMenu.create("bauplan");
                SelectMenu bauplan = SelectMenu.create("roleid")
                        .setPlaceholder("Hier kannst du deine Rollen aüswählen!")
                        .addOption("Gamingrollen", "gamingrole", "Hier kannst du deine Gamingrollen auswählen.")
                        .addOption("Pingrollen", "pingroles", "Hier kannst du deine Pingrollen auswählen.")
                        .addOption("Plattform", "plat", "Hier kannst du deine Platformen auswählen.")
                        .addOption("Alter", "age", "Hier kannst du dein Alter auswählen.")
                        .setRequiredRange(1, 4)
                        .build();




            }
        }
    }
}