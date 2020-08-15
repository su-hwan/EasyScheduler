package su.hwan.easyscheduler.util;

import android.app.Activity;
import android.util.Log;

import su.hwan.easyscheduler.R;

import static android.content.Context.MODE_PRIVATE;

public class EasyTheme {
    private String theme = "name_of_the_theme";
    public static final String THEME_PREFERENCES = "su.hwan.themepref";
    public static final String THEME_SAVED = "su.hwan.savedtheme";
    public static final String LIGHT_THEME = "su.hwan.lighttheme";
    public static final String DARK_THEME = "su.hwan.darktheme";
    public static final String RECREATE_ACTIVITY = "su.hwan.recreateactivity";

    public final static void setTheme(Activity activity) {
        String theme = activity.getSharedPreferences(THEME_PREFERENCES, MODE_PRIVATE)
                .getString(THEME_SAVED, LIGHT_THEME);
        Log.d("su-hwan","theme:" + theme);
        int iTheme;
        if (theme.equals(LIGHT_THEME)) {
            iTheme = R.style.CustomStyle_LightTheme;
            Log.d("su-hwan","ithemeLight:" + iTheme);
        } else {
            iTheme = R.style.CustomStyle_DarkTheme;
            Log.d("su-hwan","ithemeDark:" + iTheme);
        }
        activity.setTheme(iTheme);
    }
}
