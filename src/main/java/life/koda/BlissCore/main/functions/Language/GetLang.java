package life.koda.BlissCore.main.functions.Language;

import com.lunarclient.bukkitapi.LunarClientAPI;

public class GetLang {
    private static GetLang instance;
    public static String Common(KodaPhrase phrase) {
        switch (phrase) {
            case PLAYER_ONLY:
                return "Only players can use that command!";
            case CONSOLE_ONLY:
                return "This command may only be executed via console!";
            case NO_PERMISSION:
                return "&cYou do not have permission to execute that command!";
            case SUCCESS_LUNARENABLEMOD:
                return "&aSuccessfully enabled lunar staff mods!";
            case FAILED_LUNARENABLEMOD:
                return "&cError: You must be on lunar client to use this command! &b&nhttps://lunarclient.com/";
        }
        return null;
    }
    public static String CommandUsage(KodaPhrase phrase) {
        switch (phrase) {
            case COMMANDUSAGE_LUNARSTAFFMODULES:
                return "&cCorrect usage: /lunarstaffmodules <true/false>";
        }
        return null;
    }

}