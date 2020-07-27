package su.hwan.easyscheduler.about;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import su.hwan.easyscheduler.R;
import su.hwan.easyscheduler.appdefault.AppDefaultFragment;

public class AboutFragment extends AppDefaultFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView contactMe = (TextView) view.findViewById(R.id.aboutContactMe);

        contactMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Good bye", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_about;
    }
    public static AboutFragment newInstance() {
        return new AboutFragment();
    }
}
