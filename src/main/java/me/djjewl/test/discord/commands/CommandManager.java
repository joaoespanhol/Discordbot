package me.djjewl.test.discord.commands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import org.jetbrains.annotations.NotNull;



import static org.bukkit.Bukkit.getServer;

public class CommandManager extends ListenerAdapter {

    @Override
    public void  onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        String command = event.getName();
        if(command.equals("tplayerlist")){
            String players = String.valueOf(Bukkit.getOnlinePlayers().toString().replace("=","").replace("CraftPlayer","").replace("name","").replace("{","").replace("}",", "));
            event.reply("Playerlist!\n"+ players ).queue();

        }
        if(command.equals("user-uuid")){
            String user = event.getOption("username").getAsString();
            String uuid = String.valueOf(Bukkit.getOfflinePlayer(user).getUniqueId());
            event.reply(user+" UUID: "+uuid).setEphemeral(true).queue();
        }
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        if (event.getChannel().getId().equals("1035295383359864902")){
            getServer( ).broadcastMessage(event.getAuthor().getName()+" >> "+event.getMessage());
        }
    }


}
