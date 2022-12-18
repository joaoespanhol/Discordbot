package me.djjewl.main.discord;
import dev.JustRed23.abcm.ConfigField;
import dev.JustRed23.abcm.Configurable;
//Config File Creation Using JustRed23's ABCM (https://github.com/JustRed23/ABCM)
@Configurable
public final class foxyconfig {
    @ConfigField(defaultValue = "BotToken",description ="This is the Discord Bot token,to Get it please Follow this Tutorial https://www.technobezz.com/how-to-get-a-discord-bot-token/")
    public static String BotToken;

    @ConfigField(defaultValue = "1035295383359864902",description = "Is used to determine what channel the bot should post to needs to be a channel ID")
    public static String ChatId;

    @ConfigField(defaultValue = "Testwatch",description = "This is what the Bot will Show as Watching")
    public static String Watching;

    @ConfigField(defaultValue = "false",description = "used to TroubleShoot some issues,This is still Under Work tho")
    public static boolean Debug;

    @ConfigField(defaultValue = "#user# >> #message#",description = "Formats the discord to minecraft (you can change chat colors here to using default minecraft color codes,THIS IS NOT CURRENTLY WORKING.")
    public static String discord_to_minecraft;

}
