package com.elderlycare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DailyNeeds extends AppCompatActivity {

    HomepageAdapter adapter;

    int[] data = { R.string.medicine_alert, R.string.health, R.string.alarm,
            R.string.accident, R.string.daily, R.string.get_involved};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_needs);

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new HomepageAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
