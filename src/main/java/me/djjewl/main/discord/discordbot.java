package me.djjewl.main.discord;

import me.djjewl.main.discord.commands.CommandManager;
import me.djjewl.main.discord.configs.foxyconfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bukkit.Bukkit;

import java.util.Objects;
import java.util.logging.Level;


public class discordbot {

    private static JDA api;
    public static void botload() throws InterruptedException {
        //          DjJewl-12-16-2022 / 5:15
        //Checks If the Discord Token In config is NULL If it is not NULL it will Go ahead and Build the Discord Bot
            //          DjJewl-12-17-2022 / 7:10PM
            //Added the magma-versionCommand and added the autoComplete in CommandManager
        if(Objects.equals(foxyconfig.BotToken, "BotToken")) {
            throw new RuntimeException("the discord Token is not set please Provide discord token in config");
        }
        else {
            api = JDABuilder.createDefault(foxyconfig.BotToken).enableIntents(GatewayIntent.MESSAGE_CONTENT).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setActivity(Activity.watching(foxyconfig.Watching)).build();
            api.updateCommands().addCommands(Commands.slash("playerlist", "Gets PlayerliSt of server").setGuildOnly(true))
                    .addCommands(Commands.slash("user-uuid", "Gets the UUID of a Username!")
                            .addOption(OptionType.STRING, "username","Give the Username of the player.", true).setGuildOnly(true))
                    .addCommands(Commands.slash("magma-version", "Returns latest Version Of magma for specified version")
                                    .addOption(OptionType.STRING, "version","Version of Minecraft",true,true)).queue();
            api.addEventListener(new CommandManager());
            api.awaitReady();
        }
    }

    //          DjJewl-12-17-2022 / 9:36PM
    //send all messages from events/chatevents to discord
    public static void discordMsg(String message)
    {
        String id = foxyconfig.ChatId;
        MessageChannel channel = api.getTextChannelById(id);
        if(channel != null) {
            channel.sendMessage(message).queue();
        }//makes sure channel is not null
        if(!foxyconfig.Debug && channel == null){//if
            Bukkit.getLogger().log(Level.SEVERE, "The ChannelID in config is not Correct/issue with code contact djjewl");
        }
        if(foxyconfig.Debug) {
            Bukkit.getLogger().log(Level.SEVERE, message);
            Bukkit.getLogger().log(Level.SEVERE, foxyconfig.ChatId);
            Bukkit.getLogger().log(Level.SEVERE, String.valueOf(channel));
        }//end of debug
    }
}

