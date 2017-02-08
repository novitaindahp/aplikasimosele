package com.example.pramudita.mosele;

/**
 * Created by Noon on 27/01/2017.
 */

import android.support.design.widget.CoordinatorLayout;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import com.roughike.bottombar.BottomBar;
        import com.roughike.bottombar.OnMenuTabSelectedListener;

public class FourButtonsActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_buttons);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.four_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.home:
                        Snackbar.make(coordinatorLayout, "Home Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.module:
                        Snackbar.make(coordinatorLayout, "Module Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.pakan:
                        Snackbar.make(coordinatorLayout, "Pakan Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.grafik:
                        Snackbar.make(coordinatorLayout, "GrafikSelected", Snackbar.LENGTH_LONG).show();
                        break;
                }
            }

        });

        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.
        bottomBar.setActiveTabColor("#C2185B");

        // Use the dark theme. Ignored on mobile when there are more than three tabs.
        //bottomBar.useDarkTheme(true);

        // Use custom text appearance in tab titles.
        //bottomBar.setTextAppearance(R.style.MyTextAppearance);

        // Use custom typeface that's located at the "/src/main/assets" directory. If using with
        // custom text appearance, set the text appearance first.
        //bottomBar.setTypeFa
    }
}