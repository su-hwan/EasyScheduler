package su.hwan.easyscheduler.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import su.hwan.easyscheduler.R;
import su.hwan.easyscheduler.about.AboutActivity;
import su.hwan.easyscheduler.appdefault.AppDefaultActivity;
import su.hwan.easyscheduler.settings.SettingsActivity;

public class MainActivity extends AppDefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public int contentViewLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    protected Fragment createInitialFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Class intentClazz = null;
        switch (item.getItemId()) {
            case R.id.menu_about:
                intentClazz = AboutActivity.class;
                break;
            case R.id.menu_settings:
                intentClazz = SettingsActivity.class;
                break;
        }

        if (intentClazz != null) {
            Intent intent = new Intent(this, intentClazz);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }
}
