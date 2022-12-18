package me.djjewl.test.discord;

import me.djjewl.test.discord.commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.attribute.IGuildChannelContainer;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


public class discordbot extends ListenerAdapter {

    private static JDA api;
    public static void botload() {
        //          DjJewl-12-16-2022 / 5:15
        //Checks If the Discord Token In config is NULL If it is not NULL it will Go ahead and Build the Discord Bot
            //          DjJewl-12-17-2022 / 7:10PM
            //Added the magma-versionCommand and added the autoComplete in CommandManager
        if(sconfig.BotToken == null) {
            throw new RuntimeException("the discord Token is NULL please Provide discord token in config");
        }
        else {
            api = JDABuilder.createDefault(sconfig.BotToken).enableIntents(GatewayIntent.MESSAGE_CONTENT).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setActivity(Activity.watching("FC-Developement")).build();
            api.updateCommands().addCommands(Commands.slash("tplayerlist", "Test PlayerliSt for bot recode.").setGuildOnly(true))
                    .addCommands(Commands.slash("user-uuid", "Gets the UUID of a Username!")
                            .addOption(OptionType.STRING, "username","Give the Username of the player.", true).setGuildOnly(true))
                    .addCommands(Commands.slash("magma-version", "Returns latest Version Of magma for specified version")
                                    .addOption(OptionType.STRING, "version","Version of Minecraft",true,true)).queue();
            api.addEventListener(new CommandManager());
        }
    }
    //          DjJewl-12-16-2022 / 5:17
    //Moved From events/chatevents to me.djjewl.test.discord.discordbot
    //This will send all messages from events/chatevents to discord
    //HAVING ISSUES GETTING IT TO SEND MESSAGES TO DISCORD NEED HELP ON THIS

    public static void discordMsg(String message)
    {
        MessageChannel channel = api.getTextChannelById(sconfig.ChatId);
        assert channel != null;
        channel.sendMessage(message).queue();

    }
}

