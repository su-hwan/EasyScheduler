package su.hwan.easyscheduler.settings;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import su.hwan.easyscheduler.R;
import su.hwan.easyscheduler.appdefault.AppDefaultActivity;
import su.hwan.easyscheduler.util.EasyTheme;

public class SettingsActivity extends AppDefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasyTheme.setTheme(this);
        int backIcon = R.drawable.back_icon;
        final Drawable backArrow = getResources().getDrawable(backIcon,this.getTheme());
        if (backArrow != null) {
            backArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(backArrow);
        }
    }

    @Override
    protected int contentViewLayoutRes() {
        return R.layout.activity_appbar;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return SettingsFragment.newInstance();
    }

}
