package main;

import Chats.*;
import Commands.*;
import Einbettungen.Regeln;
import Ticket.TicketKnopf;
import Ticket.ticket;
import Willkomen.Willkommen;


import javax.security.auth.login.LoginException;

public class Hauptklasse {

    public static void main(String[] args) throws LoginException {

        String prefix = "!";

        String status;
        status = "mit dir im Keller";

       JDABuilder bauplan = JDABuilder.createDefault(token);

        bauplan.setStatus(OnlineStatus.ONLINE);
        bauplan.setActivity(Activity.streaming("in deinem Keller mit dir ","https://www.twitch.tv/chrisi_von_cyberbee"));

        bauplan.addEventListeners(new NachrichtenReation());
        bauplan.addEventListeners(new View());
        bauplan.addEventListeners(new ban());
        bauplan.addEventListeners(new Timeout());
        bauplan.addEventListeners(new Kick());
        bauplan.addEventListeners(new Verify());
        bauplan.addEventListeners(new Rollenauswahl());
        bauplan.addEventListeners(new Willkommen());
        bauplan.addEventListeners(new serverinfos());
        bauplan.addEventListeners(new Auswahlfeld());
        bauplan.addEventListeners(new profil());
        bauplan.addEventListeners(new ticket());
        bauplan.addEventListeners(new TicketKnopf());
        bauplan.addEventListeners(new Regeln());
        bauplan.addEventListeners(new ChatBestimmung());
        bauplan.addEventListeners(new Befehle());
        bauplan.addEventListeners(new Hilfmir());
        bauplan.addEventListeners(new Info());
        bauplan.addEventListeners(new News());
        bauplan.addEventListeners(new Support());
        bauplan.addEventListeners(new Vorschlag());
        bauplan.addEventListeners(new Chat());
        bauplan.addEventListeners(new FreundesChat());
        bauplan.addEventListeners(new Spielersuche());
        bauplan.addEventListeners(new pinnwand());
        bauplan.addEventListeners(new anmie());
        bauplan.addEventListeners(new clips());
        bauplan.addEventListeners(new meme());
        bauplan.addEventListeners(new Video());
        bauplan.addEventListeners(new Technik());
        bauplan.addEventListeners(new setup());
        bauplan.addEventListeners(new musik());
        bauplan.addEventListeners(new zählen());
        bauplan.addEventListeners(new kunst());
        bauplan.addEventListeners(new Haustier());
        bauplan.addEventListeners(new essen());
        bauplan.addEventListeners(new mc());
        bauplan.addEventListeners(new fn());
        bauplan.addEventListeners(new va());
        bauplan.addEventListeners(new gta());
        bauplan.addEventListeners(new CallofDuty());


        bauplan.setChunkingFilter(ChunkingFilter.ALL);
        bauplan.setMemberCachePolicy(MemberCachePolicy.ALL);
        bauplan.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGES);

        JDA bot = bauplan.build();
        System.out.println("Der Bot kommt zu dir nach Hause in deinen Keller");


    }
}
