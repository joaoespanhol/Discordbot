package me.djjewl.test.discord.commands;


import com.google.gson.JsonElement;
import me.djjewl.test.discord.http.magmarequest;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.bukkit.Bukkit;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;


import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.bukkit.Bukkit.getServer;

public class CommandManager extends ListenerAdapter {
    //          DjJewl-12-17-2022 / 9:30AM
    //Is a list of possible Minecraft Versions
    private String[] ver = new String[]{"1.12.2", "1.18.2"};
    //          DjJewl-12-16-2022 / 5:09PM
    //Finds if Command Name Is a Command
    @Override
    public void  onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        String command = event.getName();
        //          DjJewl-12-16-2022 / 5:10PM
        //Returns Playerlist
        if(command.equals("tplayerlist")){
            String players = String.valueOf(Bukkit.getOnlinePlayers().toString().replace("=","").replace("CraftPlayer","").replace("name","").replace("{","").replace("}",", "));
            event.reply("Playerlist!\n"+ players ).queue();

        }
        //          DjJewl-12-16-2022 / 5:09PM
        //Returns UUID of Player Name Inputted
        if(command.equals("user-uuid")){
            String user = event.getOption("username").getAsString();
            String uuid = String.valueOf(Bukkit.getOfflinePlayer(user).getUniqueId());
            event.reply(user+" UUID: "+uuid).setEphemeral(true).queue();
        }

        //          DjJewl-12-17-2022 / 7:06PM
        //Returns the latest Version Of magma for either 1.18.2 or 1.12.2 and the GitLab Link
       if(command.equals("magma-version")){
           String version = event.getOption("version").getAsString();
            if(version.equals("1.18.2") || version.equals("1.12.2")) {
                JsonElement Response = magmarequest.mvrequest(version);
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Magma Version : "+version);
                eb.addField("Magma "+version+" Download", "[Download]"+"("+(Response.getAsJsonObject().get("link").getAsString().replaceAll("\"", ""))+")", false);
                eb.addField("Magma "+version+" Changes", "[GitLab]"+"("+(Response.getAsJsonObject().get("git_commit_url").getAsString().replaceAll("\"", ""))+")", false);
                eb.setAuthor("Magma", "https://magmafoundation.org/", "https://magmafoundation.org/images/magma-logo.png");
                eb.setFooter("Ownership of Files/Logo To Magma Development");
                event.replyEmbeds(eb.build()).queue();
            }
       }

    }
    //          DjJewl-12-16-2022 / 5:10
    //watches the Discord For MessageReceived Events
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        //          DjJewl-12-16-2022 / 5:11PM
        //Checks channel ID,Then Sends Message In channel to Minecraft
        if (event.getChannel().getId().equals("1035295383359864902")){
            getServer( ).broadcastMessage(event.getAuthor().getName()+" >> "+event.getMessage());
        }
    }
    //          DjJewl-12-17-2022 / 9:30AM
    //AutoCompletes the Version Option For the User
    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        if (event.getName().equals("magma-version") && event.getFocusedOption().getName().equals("version")) {
            List<Command.Choice> options = Stream.of(ver)
                    .map(word -> new Command.Choice(word, word)) // map the words to choices
                    .collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
    }
}
