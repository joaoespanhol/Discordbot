package me.djjewl.test.discord;
import dev.JustRed23.abcm.ConfigField;
import dev.JustRed23.abcm.Configurable;
//Config File Creation Using JustRed23's ABCM (https://github.com/JustRed23/ABCM)
@Configurable
public final class sconfig {
    @ConfigField(defaultValue = "00000")
    public static String BotToken;

    @ConfigField(defaultValue = "00000")
    public static String ChatId;


}
