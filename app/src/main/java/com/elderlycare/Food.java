package com.elderlycare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Food extends AppCompatActivity {

    HomepageAdapter adapter;

    static int[] myImageList = new int[]{R.drawable.ic_breakfast, R.drawable.ic_lunch ,R.drawable.ic_dinner ,
            R.drawable.ic_snacks };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        int[] data = { R.string.medicine_alert, R.string.health, R.string.alarm,
                R.string.accident, R.string.daily, R.string.get_involved};

        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new HomepageAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
