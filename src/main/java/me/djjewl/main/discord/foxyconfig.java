package me.djjewl.main.discord;
import dev.JustRed23.abcm.ConfigField;
import dev.JustRed23.abcm.Configurable;
//Config File Creation Using JustRed23's ABCM (https://github.com/JustRed23/ABCM)
@Configurable
public final class foxyconfig {
    @ConfigField(defaultValue = "BotToken")
    public static String BotToken;

    @ConfigField(defaultValue = "1035295383359864902")
    public static String ChatId;

    @ConfigField(defaultValue = "Testwatch")
    public static String Watching;

    @ConfigField(defaultValue = "false")
    public static boolean Debug;


}
