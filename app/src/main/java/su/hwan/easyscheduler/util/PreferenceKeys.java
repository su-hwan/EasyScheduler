package su.hwan.easyscheduler.util;

import android.content.res.Resources;

import su.hwan.easyscheduler.R;

public class PreferenceKeys {
    public final String night_mode_pref_key;

    public PreferenceKeys(Resources resources) {
        this.night_mode_pref_key = resources.getString(R.string.night_mode_pref_key);
    }
}
