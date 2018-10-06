package com.elderlycare;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elderlycare.Medicine_Alert.MedicineActivity;

public class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.ViewHolder> {

    private Context context;
    private int[] mData;
    private LayoutInflater mInflater;
    int i = 0;


    HomepageAdapter(Context context, int[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_page_options_sample, parent, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomepageAdapter.ViewHolder holder, int position) {

        final String text = holder.itemView.getResources().getString(mData[position]);
        holder.myTextView.setText(text);
        holder.imageView.setImageResource(Homepage.myImageList[i]);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.contains("Medicine Alert")){
                    Intent intent = new Intent(context, MedicineActivity.class);
                    v.getContext().startActivity(intent);

                } else
                if(text.contains("Daily Needs")){
                    Intent intent = new Intent(context, DailyNeeds.class);
                    v.getContext().startActivity(intent);
                } else
                if(text.contains("Health and Food")){
                    Intent intent = new Intent(context, Food.class);
                    v.getContext().startActivity(intent);

                }
                else{
                    Intent intent = new Intent(context, Homepage.class);
                    intent.putExtra("activityName", text);
                    intent.putExtra("type", holder.myTextView.getText());
                    v.getContext().startActivity(intent);
                }

            }
        });
        i++;
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ImageView imageView;
        CardView card;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            imageView = itemView.findViewById(R.id.img_sampla);
            card = itemView.findViewById(R.id.sample_card);
        }
    }
}
