package com.example.topic9_listview;

import android.view.View;
import android.widget.ImageView;

public class ViewHolder {
    ImageView icon = null;

    ViewHolder(View base){
        this.icon = (ImageView) base.findViewById(R.id.imageView_poster);
    }
}
