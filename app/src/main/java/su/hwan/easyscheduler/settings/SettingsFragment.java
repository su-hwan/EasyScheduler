package su.hwan.easyscheduler.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;

import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceFragmentCompat;

import su.hwan.easyscheduler.R;
import su.hwan.easyscheduler.util.EasyTheme;
import su.hwan.easyscheduler.util.PreferenceKeys;


public class SettingsFragment extends PreferenceFragmentCompat implements OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_layout, rootKey);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        PreferenceKeys prefKeys = new PreferenceKeys(getResources());
        if (key.equals(prefKeys.night_mode_pref_key)) {
            SharedPreferences themePref = getActivity().getSharedPreferences(EasyTheme.THEME_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor themeEditor = themePref.edit();
            themeEditor.putBoolean(EasyTheme.RECREATE_ACTIVITY,true);

            CheckBoxPreference checkBox = findPreference(prefKeys.night_mode_pref_key);
            if (checkBox.isChecked()) {
                themeEditor.putString(EasyTheme.THEME_SAVED,EasyTheme.DARK_THEME);
            } else {
                themeEditor.putString(EasyTheme.THEME_SAVED,EasyTheme.LIGHT_THEME);
            }
            themeEditor.apply();

            getActivity().recreate();
        }
    }

    protected static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
