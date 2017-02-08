package com.example.pramudita.mosele;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noonart on 10/11/2016.
 */
public class Notifikasi extends AppCompatActivity {
    String namapetani;
    TextView tampilnamapetani;
    private Toolbar toolbar;
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private int[] tabIcon = {
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_module,
            R.drawable.ic_tab_notif,
            R.drawable.ic_tab_grafik,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.dashboard);
        tampilnamapetani = (TextView) findViewById(R.id.namapetani) ;

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            namapetani = extras.getString("namapet") ;

            tampilnamapetani.setText(""+namapetani);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MOSELE");

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            Drawable drawable=getResources().getDrawable(R.drawable.ic_launcerlele);
            Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
            Drawable newDraw=new BitmapDrawable(getResources(),Bitmap.createScaledBitmap(bitmap,50,50,true));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(newDraw);

        }


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tableLayout = (TabLayout) findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);
        setupTabIcon();
    }

    private void setupTabIcon(){
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Home");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_home, 0, 0);
        tableLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Module");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_module, 0, 0);
        tableLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Notif");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_notif, 0, 0);
        tableLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("jual");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_grafik, 0, 0);
        tableLayout.getTabAt(3).setCustomView(tabFour);




    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Home");
        adapter.addFragment(new TwoFragment(), "Module");
        adapter.addFragment(new TreeFragment(), "Notif");
        adapter.addFragment(new FourFragment(), "jual");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public  ViewPagerAdapter (FragmentManager manager){
            super(manager);
        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {

            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }

}


