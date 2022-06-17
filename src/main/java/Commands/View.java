package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static main.Hauptklasse.*;

public class View extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().startsWith("!view")) {

            if (ereignis.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {

                Member mitglied =ereignis.getMessage().getMentionedMembers().get(0);

                EmbedBuilder bauplan = new EmbedBuilder();


                bauplan.setTitle("Nutzerinfomation zu " + mitglied.getEffectiveName());
                bauplan.setColor(0xffa900);
                bauplan.setThumbnail(mitglied.getEffectiveAvatarUrl());

                bauplan.addField("Nutzername" , mitglied.getAsMention() , true);
                bauplan.addField("Nutzer ID" , mitglied.getId() , true);
                bauplan.addField("Aktueller Status" , "Online" , true);
                bauplan.addField("Rollenanzahl",String.valueOf(mitglied.getRoles().stream().count()),true);
                bauplan.addField("Höchste Rolle" , String.valueOf(mitglied.getRoles().get(0)), true);
                bauplan.addField("Hat sein Account erstellt am:", mitglied.getTimeCreated().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), false);
                bauplan.addField("Auf dem Server seit:", mitglied.getTimeJoined().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), false);
                bauplan.addField("Bestrafungen" , "Keine" , true);
                bauplan.addField("Abzeichen" , "keine" , true);

                bauplan.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");


                Button NutzerBestrafung = Button.danger("Userdamage" , "Nutzer bestrafen").withEmoji(Emoji.fromMarkdown("<:Ban:928229381468467220>"));
                Button NicknameÄndern = Button.primary("UserNickname" , "Nickname ändern").withEmoji(Emoji.fromMarkdown("<:name:985884655020556298>"));
                Button moreInformations = Button.success("moreInformationen" , "Details").withEmoji(Emoji.fromMarkdown("➕"));
                Button Dataexport = Button.secondary("DataExport" , "Datei Exportieren").withEmoji(Emoji.fromMarkdown("\uD83D\uDCC4"));

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(NutzerBestrafung , NicknameÄndern , moreInformations , Dataexport).queue();

            }
        }
    }

    public  void onButtonInteraction (ButtonInteractionEvent ereignis) {

        if (ereignis.getButton().getId().equals("Userdamage")) {

            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(0xffa900);
            embed.setTitle("Wie möchtest du den Nutzer bestrafen?");

            ereignis.getChannel().sendMessageEmbeds(embed.build()).queue();
            ereignis.deferEdit().queue();
        }

        if (ereignis.getButton().getId().equals("UserNickname")) {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setColor(0xffa900);
            bauplan.setTitle("Wie lautet dein neuer Nickname?");

            Button buttonNick = Button.danger("buttonNick", "Überspringen");
            Button buttonnickfinnish = Button.secondary("buttonfinishnick", "Fertig!");

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(buttonNick, buttonnickfinnish).queue();
            ereignis.deferEdit().queue();

        }

        if (ereignis.getButton().getId().equals("buttonNick")) {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Der Nutzername wurde nicht geändert");
            bauplan.setColor(0xffa900);

            Button nickabbruch = Button.danger("nickabbruch", "Abbruch").withEmoji(Emoji.fromMarkdown("❌"));

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(nickabbruch).queue();
            ereignis.deferEdit().queue();

        }

        if (ereignis.getButton().getId().equals("buttonfinishnick")) {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Dein Nickname wurde erfolgreich geändert");
            bauplan.setColor(0xffa900);

            Button nickfinishedsucces = Button.success("nickfinishsucces", "Erfolreich").withEmoji(Emoji.fromMarkdown("✅"));

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(nickfinishedsucces).queue();
            ereignis.deferEdit().queue();

        }

        if (ereignis.getButton().getId().equals("moreInformationen")) {

            Member mitglied = ereignis.getMessage().getMentionedMembers().get(0);
            User user = ereignis.getUser();

            EmbedBuilder bauplan = new EmbedBuilder();


            bauplan.setTitle("Nutzerinfomation zu " + mitglied.getEffectiveName());
            bauplan.setColor(0xffa900);
            bauplan.setThumbnail(mitglied.getEffectiveAvatarUrl());

            bauplan.addField("Nutzername", mitglied.getEffectiveName(), true);
            bauplan.addField("Nutzer ID", mitglied.getId(), true);
            bauplan.addField("Aktueller Status", "Online", true);
            bauplan.addField("Hat sein Account erstellt am:", String.valueOf(mitglied.hasTimeJoined()), true);
            bauplan.addField("Auf dem Server seit:", String.valueOf(mitglied.getTimeCreated()), true);
            bauplan.addField("Bestrafungen", "Keine", true);


            Button Dataexportoprivate = Button.secondary("dataprivateexport" , "Datei Exportieren").withEmoji(Emoji.fromMarkdown("\uD83D\uDCC4"));

            user.openPrivateChannel().complete().sendMessageEmbeds(bauplan.build()).queue();

            EmbedBuilder embed = new EmbedBuilder();

            embed.setTitle("Eine DM mit mehreren Informationen wurde dir geschickt");
            embed.setColor(0xffa900);
            Button moreinformationsucces = Button.success("moreinformationsucces", "Erfolreich").withEmoji(Emoji.fromMarkdown("✅"));
            Button profildata = Button.link(mitglied.getAvatarUrl() , "Profilbild abrufen");

            User nutzer = ereignis.getUser();

            ereignis.getChannel().sendMessageEmbeds(embed.build()).setActionRow(moreinformationsucces).queue();
            ereignis.deferEdit().queue();
        }

        if (ereignis.getButton().getId().equals("moreinformationsucces")) {

            User nutzer = ereignis.getUser();

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Hier ist die verlangte Datei:");
            bauplan.setColor(0xffa900);
            bauplan.setDescription("ViewprivateDatei");

            Button succesprivate = Button.success("succesprivatedata" , "Erfolgreich").withEmoji(Emoji.fromMarkdown("✅"));

            nutzer.openPrivateChannel().complete().sendMessageEmbeds(bauplan.build()).setActionRow(succesprivate).queue();

        }

        if (ereignis.getButton().getId().equals("DataExport")) {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Hier ist die Verlangte Datei");
            bauplan.setColor(0xffa900);
            bauplan.setDescription("ViewDatei");

            Button buttonsucces = Button.success("buttondatasucces", "Erfolgreich").withEmoji(Emoji.fromMarkdown("✅"));

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(buttonsucces).queue();
            ereignis.deferEdit().queue();
        }

        if (ereignis.getButton().getId().equals("moreinformationsucces")) {

            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Erfolg");
            bauplan.setColor(0xffa900);

            ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();
        }

    }
}

