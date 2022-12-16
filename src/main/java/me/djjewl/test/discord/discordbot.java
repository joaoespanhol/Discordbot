package me.djjewl.test.discord;

import me.djjewl.test.discord.commands.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


public class discordbot extends ListenerAdapter {


    public static void botload(String args) {
        //          DjJewl-12-16-2022 / 5:15
        //Checks If the Discord Token In config is NULL If it is not NULL it will Go ahead and Build the Discord Bot
        if(args == null) {
            throw new RuntimeException("the discord Token is NULL please Provide discord token in config");
        }
        else {
            JDA api = JDABuilder.createDefault(args).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setActivity(Activity.watching("FC-Developement")).build();
            api.updateCommands().addCommands(Commands.slash("tplayerlist", "Test PlayerliSt for bot recode.").setGuildOnly(true)).addCommands(Commands.slash("user-uuid", "Gets the UUID of a Username!").addOption(OptionType.STRING, "username","Give the Username of the player.", true).setGuildOnly(true)).queue();
            api.addEventListener(new CommandManager());
        }
    }
    //          DjJewl-12-16-2022 / 5:17
    //Moved From events/chatevents to me.djjewl.test.discord.discordbot
    //This will send all messages from events/chatevents to discord
    public static void discordMsg(String message ) {

    }
}

