package com.elderlycare;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bikomobile.circleindicatorpager.CircleIndicatorPager;

import java.util.Timer;
import java.util.TimerTask;

public class Homepage extends AppCompatActivity {

    HomepageAdapter adapter;
    private int currentPage = 0;
    private Timer timer;
    private ViewPager viewPager;
    final long DELAY_MS = 1000;
    final long PERIOD_MS = 2700;
    static int[] myImageList = new int[]{R.drawable.ic_pills, R.drawable.ic_hot_pot ,R.drawable.ic_alarm ,
            R.drawable.ic_accident ,R.drawable.ic_online_shop, R.drawable.ic_friends_talking, R.drawable.ic_friends_talking,
            R.drawable.ic_friends_talking, R.drawable.ic_friends_talking};


    int[] images = { R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        String[] data = { "Medicine Alert", "Health & Food", "Set Alarm", "Accident Alerts", "Daily Needs", "Get Involved", "", "","" };

        RecyclerView recyclerView = findViewById(R.id.homePageOptionsRv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new HomepageAdapter(this, data);
        recyclerView.setAdapter(adapter);

        setViewPager(images);
    }

    private void setViewPager(int[] getAllImages) {
        viewPager = findViewById(R.id.view_pager_images);
        final ImagePagerAdapter adapter = new ImagePagerAdapter(Homepage.this, getAllImages);
        viewPager.setAdapter(adapter);

        if (viewPager != null) {
            viewPager.setAdapter(adapter);

            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == adapter.getCount()) {
                        currentPage = 0;
                    }
                    viewPager.setCurrentItem(currentPage++, true);
                }
            };

            timer = new Timer();
            timer .schedule(new TimerTask() { // task to be scheduled

                @Override
                public void run() {
                    handler.post(Update);
                }
            }, DELAY_MS, PERIOD_MS);

        }

        //CircleIndicator
        CircleIndicatorPager indicator = findViewById(R.id.circle_indicator_pager);
        if (indicator != null) {
            indicator.setViewPager(viewPager);
        }else {
            Log.wtf("TAG" , "Indicator null");
        }
    }
}
