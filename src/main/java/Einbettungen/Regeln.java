package Einbettungen;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Regeln extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent ereignis) {

        if (ereignis.getMessage().getContentStripped().equals("!setup regeln")) {


            if (ereignis.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                ereignis.getChannel().sendTyping().queue();

                EmbedBuilder bild = new EmbedBuilder();

                bild.setImage("https://cdn.discordapp.com/attachments/974056971747594320/986596298738245682/Regelwerk.png");
                bild.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bild.build()).queue();
                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setTitle("Unsere Discord Regeln:");
                bauplan.setThumbnail("https://cdn.discordapp.com/attachments/956658893273038898/986029891092889711/grafik_leichteSprache-gesetz_DetailKlein_XS_SM_MD_LG.png");
                bauplan.setColor(0xffa900);
                bauplan.setDescription("Hier stehen all unsere Regeln die du als du dich verifiziert hast und somit bestätigt!");
                bauplan.addField("", "**1.** *Sei freundlich und höflich. Behandeln Sie alle Mitglieder mit Respekt und äußern Sie Ihre Gedanken auf konstruktive Weise.*", false);
                bauplan.addField("", "**2.** *Keine explizite Sprache jeglicher Art, einschließlich Fluchen und Schimpfen. Jeder Versuch, verbotene Wörter zu umgehen, ist verboten und wird genauso bestraft wie die direkte Verwendung des verbotenen Wortes. Dazu gehört auch das Wiederholen einer modifizierten Version eines automatisch gesperrten Wortes.*", false);
                bauplan.addField("", "**3.** *Verwenden Sie einen geeigneten Benutzernamen, Avatar und eine Statusmeldung.*", false);
                bauplan.addField("", "**4.** *Spammen sie nicht. Vermeiden Sie übermäßige Nachrichten, Bilder, Formatierungen, Emojis, Befehle und @Erwähnungen.*", false);
                bauplan.addField("", "**5.** *Erwähnen Sie Teamler nicht ohne guten Grund. Wenn Sie Hilfe benötigen, schauen Sie zuerst hier in den Chats nach wo fragen beantwortet werden (Hilf Mir) oder erstellen sie ein Ticket.*", false);
                bauplan.addField("","**6.**  *Keine Eigenwerbung und Werbung. Dazu gehören unaufgeforderte Verweise und Links die nicht in unsere Liste stehen und Direktnachrichten oder Discord-Status, einschließlich vorgestellter Server. Eine Ausnahme gibt es für Links die in der Liste stehen.*",true);
                bauplan.addField("", "**7.** *Keine persönlichen Informationen. Dazu gehört die Weitergabe spezifischer Informationen über Ihr Alter und Ihren tatsächlichen Standort Telefonnummer und weiteres. Sollte es zu Konflikten kommen, ist der Support aber nicht dafür zuständig.*", false);
                bauplan.addField("", "**8.** *Keine Belästigung, Beleidigung oder Mobbing.* ", false);
                bauplan.addField("", "**9.** *Keine rassistischen, sexistischen, gegen LGBTQ+ gerichteten, antireligiösen oder anderweitig anstößigen Inhalte. Wir tolerieren keine Hassreden.*", false);
                bauplan.addField("", "**10.** *Keine politischen oder religiösen Themen.*", false);
                bauplan.addField("", "**11.** *Keine Piraterie, sexuelle, NSFW oder anderweitig verdächtige Inhalte. Wir dulden keine illegalen oder verdächtigen Diskussionen und Aktivitäten.*", false);
                bauplan.addField("", "**12.** *Alle oben genannten Regeln gelten auch in unseren Sprachkanälen. Bevor Sie einem verwendeten Sprachkanal beitreten, fragen Sie die Personen, die sich bereits im Kanal befinden, um Erlaubnis.*", false);
                bauplan.addField("", "**13.** *Verwenden Sie keine (externen) Emojis, die unangemessene Sprache enthalten, weder im Emoji-Namen noch im Emoji selbst.*", false);
                bauplan.addField("", "**14.** *Wenn euch jemand auffällt der gegen eine Regel verstoßen hat und ein Moderatoren, Supporter, Admins  sich noch nicht gekümmert hat meldet euch bei Ban und Kick oder bei Hilf Mir .*", false);
                bauplan.addField("", "**15.** *Den Anweisungen des Teams ist Folge zu leisten. Teammitglieder haben das Recht, einen User auch für nicht in den Regeln erwähnte Gründe zu verwarnen, wenn es aus ihrer Sicht verwarnbar ist. Das Team wird zu keinem Zeitpunkt aufgrund von Regelverstößen nach persönlichen Daten fragen. Solltest du eine Beschwerde einreichen wollen, dann kontaktiere einen Admins.*", false);
                bauplan.addField("", "**16.** *Regeln unterliegen dem gesunden Menschenverstand. Für die Auslegung und Durchsetzung sind die Teammitglieder von CyberBee´s verantwortlich.*", false);
                bauplan.addField(""," **Info:** *Das Team ist dazu berechtigt die Regeln jederzeit zu verändern. Es wird bei jeder Änderung ein Bericht gesendet. Mit dem Betreten des Servers akzeptierst du außerdem alle Regeln und erklärst dich damit einverstanden, dass jegliche Regelbrüche Strafen als Konsequenzen herbeiführen können.*",false);
                bauplan.setImage("https://cdn.discordapp.com/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png");

                ereignis.getChannel().sendMessageEmbeds(bauplan.build()).queue();

                EmbedBuilder bedienfeld = new EmbedBuilder();

                bedienfeld.setTitle("Mit freundlichen Grüßen das Team von Game Time :video_game:  by Cyber Bees :bee: ");
                bedienfeld.setDescription("~Stand vom 14.06.22. um 00:20 Uhr~");
                bedienfeld.setImage("https://media.discordapp.net/attachments/956658893273038898/985290215658778644/Einbettungs_Ende_Bot.xyz.png?width=1296&height=50");
                bedienfeld.setColor(0xffa900);

                ereignis.getChannel().sendMessageEmbeds(bedienfeld.build()).queue();




            }
        }
    }
}