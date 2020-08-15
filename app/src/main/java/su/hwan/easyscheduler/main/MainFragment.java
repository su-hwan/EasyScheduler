package su.hwan.easyscheduler.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import su.hwan.easyscheduler.R;
import su.hwan.easyscheduler.appdefault.AppDefaultFragment;
import su.hwan.easyscheduler.util.EasyTheme;

public class MainFragment extends AppDefaultFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EasyTheme.setTheme(this.getActivity());
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
