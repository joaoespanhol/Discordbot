package me.djjewl.main.discord;
import dev.JustRed23.abcm.Config;
import dev.JustRed23.abcm.exception.ConfigInitException;
import me.djjewl.main.discord.configs.foxyconfig;
import me.djjewl.main.discord.events.chatevents;
import net.dv8tion.jda.api.JDA;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Loading the Configs
        Config.setDebug(foxyconfig.Debug);
        Config.addScannable(foxyconfig.class);

        try {
            Config.init();
            Config.rescan(true);
            Config.save();
        } catch (ConfigInitException e) {
            for(Throwable cause : e.getCauses()){
                System.out.println(cause);
            }
        }
        //DiscordBot load
        try {
            discordbot.botload();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Register Events
        getServer().getPluginManager().registerEvents(new chatevents(), this);

        String message = "Server Started";
        discordbot.discordMsg(message);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //Below Here it makes message Server Stopped then kills the Discord Bot.
        Config.destroy();
        String message = "Server Stopped";
        discordbot.discordMsg(message);
        JDA jda = null;
        jda.shutdownNow();
        while (jda.getStatus() != JDA.Status.SHUTDOWN) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
