package com.example.murodjonrahimov.hackathon.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.murodjonrahimov.hackathon.R;
import com.example.murodjonrahimov.hackathon.model.Jobs;

/**
 * Created by c4q on 3/3/18.
 */

public class JobsViewHolder extends RecyclerView.ViewHolder {


    TextView textView;
    public JobsViewHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.agency_textView);



    }

    public void onBind(Jobs jobs) {


        textView.setText(jobs.getAgency());
    }
}
