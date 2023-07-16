package androidx.leanback.leanbackshowcase.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.leanbackshowcase.R;

public class MainApps extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView button = (ImageView) findViewById(R.id.search1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Search Not Found!", Toast.LENGTH_LONG).show();

            }
        });
        if (savedInstanceState == null) {
            Fragment fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
