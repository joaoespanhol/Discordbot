package me.djjewl.test.discord.events;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;




public class chatevents {


    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event) {
        String message = event.getPlayer().getName() + ": " + event.getMessage();
        discordMsg(message);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = event.getPlayer().getName() + " Joined.";
        discordMsg(message);


    }



    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String message = event.getPlayer().getName() + " Left. ";
        discordMsg(message);

    }

    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        discordMsg(event.getDeathMessage());
    }

    private void discordMsg(String message ){




    }




}
