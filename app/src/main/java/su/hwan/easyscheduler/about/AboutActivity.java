package su.hwan.easyscheduler.about;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import su.hwan.easyscheduler.util.SetTheme;

public class AboutActivity extends AppDefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String appVersion = "";
        SetTheme.setTheme(this);
        int backIcon = R.drawable.back_icon;
        final Drawable backArrow = getResources().getDrawable(backIcon,this.getTheme());
        if (backArrow != null) {
            backArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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
        return R.layout.activity_about;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return AboutFragment.newInstance();
    }
}
