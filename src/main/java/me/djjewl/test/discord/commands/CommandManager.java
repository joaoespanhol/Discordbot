package me.djjewl.test.discord.commands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import org.jetbrains.annotations.NotNull;



import static org.bukkit.Bukkit.getServer;

public class CommandManager extends ListenerAdapter {

    //          DjJewl-12-16-2022 / 5:09
    //Finds if Command Name Is a Command
    @Override
    public void  onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        String command = event.getName();
        //          DjJewl-12-16-2022 / 5:10
        //Returns Playerlist
        if(command.equals("tplayerlist")){
            String players = String.valueOf(Bukkit.getOnlinePlayers().toString().replace("=","").replace("CraftPlayer","").replace("name","").replace("{","").replace("}",", "));
            event.reply("Playerlist!\n"+ players ).queue();

        }
        //          DjJewl-12-16-2022 / 5:09
        //Returns UUID of Player Name Inputted
        if(command.equals("user-uuid")){
            String user = event.getOption("username").getAsString();
            String uuid = String.valueOf(Bukkit.getOfflinePlayer(user).getUniqueId());
            event.reply(user+" UUID: "+uuid).setEphemeral(true).queue();
        }
    }
    //          DjJewl-12-16-2022 / 5:10
    //watches the Discord For MessageReceived Events
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        //          DjJewl-12-16-2022 / 5:11
        //Checks channel ID,Then Sends Message In channel to Minecraft
        if (event.getChannel().getId().equals("1035295383359864902")){
            getServer( ).broadcastMessage(event.getAuthor().getName()+" >> "+event.getMessage());
        }
    }


}
