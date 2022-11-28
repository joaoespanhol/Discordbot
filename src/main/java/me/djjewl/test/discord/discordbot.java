package me.djjewl.test.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


public class discordbot extends ListenerAdapter {


    public static void botload(String args) {
        if(args == null) {
            throw new RuntimeException("the discord Token is NULL please Provide discord token in config");
        }
        else {
            JDA api = JDABuilder.createDefault(args).disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE).setBulkDeleteSplittingEnabled(false).setActivity(Activity.watching("FC-Developement")).build();
            api.updateCommands().addCommands(Commands.slash("tplayerlist", "Test PlayerliSt for bot recode.").setGuildOnly(true)).queue();
        }
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if (event.getName().equals("tplayerlist")) {
            event.reply(event.getOption("WIP").getAsString()).queue(); // reply immediately
    }
    }
}
