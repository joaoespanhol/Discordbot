package me.djjewl.test.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

public class discordbot extends ListenerAdapter {
    public static void botload(String args){
        JDABuilder builder = JDABuilder.createDefault(args);

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("FoxyCraft"));

        builder.build();
        //Commands

        Commands.slash("tplayerlist","Test PlayerliSt for bot recode.")
                .setGuildOnly(true); // this doesn't make sense in DMs

    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if (event.getGuild() == null)
            return;
        switch (event.getName()){
            case "tplayerlist":
                event.reply("WIP");
            default:
            event.reply("I can't handle that command right now :(").setEphemeral(true).queue();
    }
    }
}
