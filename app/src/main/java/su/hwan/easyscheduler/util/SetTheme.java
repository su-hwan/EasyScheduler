package su.hwan.easyscheduler.util;

import android.app.Activity;

import su.hwan.easyscheduler.R;

import static android.content.Context.MODE_PRIVATE;

public class SetTheme {
    private String theme = "name_of_the_theme";
    public static final String THEME_PREFERENCES = "su.hwan.themepref";
    public static final String THEME_SAVED = "su.hwan.savedtheme";
    public static final String LIGHT_THEME = "su.hwan.lighttheme";

    public final static void setTheme(Activity activity) {
        String theme = activity.getSharedPreferences(THEME_PREFERENCES, MODE_PRIVATE)
                .getString(THEME_SAVED, LIGHT_THEME);
        int iTheme;
        if (theme.equals(LIGHT_THEME)) {
            iTheme = R.style.CustomStyle_LightTheme;
        } else {
            iTheme = R.style.CustomStyle_DarkTheme;
        }
        activity.setTheme(iTheme);
    }
}
