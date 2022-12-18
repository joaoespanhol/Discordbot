package me.djjewl.test.discord.events;



import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.djjewl.test.discord.discordbot.discordMsg;


public class chatevents {

    //          DjJewl-12-16-2022 / 5:08
    //On player Chat Send Chat Message to Discord.
    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event) {
        String message = event.getPlayer().getName() + ": " + event.getMessage();
        discordMsg(message);
    }

    //          DjJewl-12-16-2022 / 5:08
    //On player Join Send Join Message to Discord
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = event.getPlayer().getName() + " Joined.";
        discordMsg(message);


    }

    //          DjJewl-12-16-2022 / 5:07
    //On player Leave Send Quit Message to Discord
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String message = event.getPlayer().getName() + " Left. ";
        discordMsg(message);

    }
    //          DjJewl-12-16-2022 / 5:07
    //On player Death Send DethMessage to discord Chat.
    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        discordMsg(event.getDeathMessage());
    }
}
