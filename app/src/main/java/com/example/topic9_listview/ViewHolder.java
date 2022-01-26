package com.example.topic9_listview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

public class ViewHolder {
    RatingBar rate = null;

    ViewHolder(View base){
        this.rate = (RatingBar) base.findViewById(R.id.rate);
    }
}
