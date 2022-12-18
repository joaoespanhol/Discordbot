package me.djjewl.test.discord;
import dev.JustRed23.abcm.Config;
import dev.JustRed23.abcm.exception.ConfigInitException;
import me.djjewl.test.discord.events.chatevents;
import net.dv8tion.jda.api.entities.channel.attribute.IGuildChannelContainer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Loading the Configs
        Config.setDebug(true);
        Config.addScannable(sconfig.class);
        try {
            Config.init();
        } catch (ConfigInitException e) {
            throw new RuntimeException(e);
        }
        //DiscordBot load
        discordbot.botload();
        //Register Events
        getServer().getPluginManager().registerEvents(new chatevents(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
