package me.djjewl.test.discord;
import dev.JustRed23.abcm.Config;
import dev.JustRed23.abcm.exception.ConfigInitException;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Loading the Configs
        Config.setDebug(true);
        Config.addScannable("me.djjewl.test.discord"); //This package was used in the TestConfig example
        Config.addScannable(sconfig.class.getPackage()); //We can also scan by mentioning the Package instance
        Config.addScannable(sconfig.class); //We can also just get the package by mentioning the class
        try {
            Config.init();
        } catch (ConfigInitException e) {
            throw new RuntimeException(e);
        }
        //DiscordBot load
        discordbot.botload(sconfig.BotToken);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
