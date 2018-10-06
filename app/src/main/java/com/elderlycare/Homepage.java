package com.elderlycare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Homepage extends AppCompatActivity {

    HomepageAdapter adapter;
    static int[] myImageList = new int[]{R.drawable.ic_breakfast, R.drawable.ic_dinner ,R.drawable.ic_lunch ,
            R.drawable.ic_snacks ,R.drawable.ic_cakes, R.drawable.ic_fruit };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        String[] data = { "Medicine Alert", "Health & Food", "Set Alarm", "Accident Alerts", "Daily Needs", "Get Involved"};

        RecyclerView recyclerView = findViewById(R.id.homePageOptionsRv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new HomepageAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
