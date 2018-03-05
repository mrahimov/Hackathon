package com.example.murodjonrahimov.hackathon.backend;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.murodjonrahimov.hackathon.model.MyFavourite;
import com.example.murodjonrahimov.hackathon.views.ParksViewHolder;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        MyFavourite myFavourite = intent.getParcelableExtra(ParksViewHolder.SAVED_MY_FAVOURITE);
        AppDatabase db = AppDatabase.getAppDatabase(getBaseContext());
        db.myFavDao().addFavourite(myFavourite);
    }
}
