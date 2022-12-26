package me.djjewl.main.discord.events;



import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import me.djjewl.main.discord.discordbot;
import me.djjewl.main.discord.configs.foxyconfig;
import org.apache.commons.lang.text.StrSubstitutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Map;

import static me.djjewl.main.discord.configs.foxyconfig.advancementtodiscord;


public class chatevents implements Listener {

    //          DjJewl-12-16-2022 / 5:08
    //On player Chat Send Chat Message to Discord.
    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event) {
        String format = foxyconfig.minecraft_to_discord;
        Map<String, Object> replacementStrings = Map.of(
                "user", event.getPlayer().getName(),
                "message", event.getMessage()
        );
        StrSubstitutor sub = new StrSubstitutor(replacementStrings , "#", "#");
        String message = sub.replace(format );
        discordbot.discordMsg(message);
    }

    //          DjJewl-12-16-2022 / 5:08
    //On player Join Send Join Message to Discord
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        String format = foxyconfig.playerjoinformat;
        Map<String, Object> replacementStrings = Map.of(
                "user", event.getPlayer().getName()
        );
        StrSubstitutor sub = new StrSubstitutor(replacementStrings , "#", "#");
        String message = sub.replace(format );
        discordbot.discordMsg(message);


    }

    //          DjJewl-12-16-2022 / 5:07
    //On player Leave Send Quit Message to Discord
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        String format = foxyconfig.playerleaveformat;
        Map<String, Object> replacementStrings = Map.of(
                "user", event.getPlayer().getName()
        );
        StrSubstitutor sub = new StrSubstitutor(replacementStrings , "#", "#");
        String message = sub.replace(format );
        discordbot.discordMsg(message);

    }
    //          DjJewl-12-16-2022 / 5:07
    //On player Death Send DethMessage to discord Chat.
    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        discordbot.discordMsg(event.getDeathMessage());
    }
    //DJJEWL 7:20 12/26/2022
    //On player achivement send message to discord if not disabled in config
    @EventHandler
    public void onPlayerAdvancementC(PlayerAdvancementCriterionGrantEvent event){if(advancementtodiscord)discordbot.discordMsg((event.getAdvancement()).toString());}

}
