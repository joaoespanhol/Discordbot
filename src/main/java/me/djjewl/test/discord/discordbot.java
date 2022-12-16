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
        if(args == null) {
            throw new RuntimeException("the discord Token is NULL please Provide discord token in config");
        }
        else {
            JDA api = JDABuilder.createDefault(args).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setActivity(Activity.watching("FC-Developement")).build();
            api.updateCommands().addCommands(Commands.slash("tplayerlist", "Test PlayerliSt for bot recode.").setGuildOnly(true)).addCommands(Commands.slash("user-uuid", "Gets the UUID of a Username!").addOption(OptionType.STRING, "username","Give the Username of the player.", true).setGuildOnly(true)).queue();
            api.addEventListener(new CommandManager());
        }
    }
}

