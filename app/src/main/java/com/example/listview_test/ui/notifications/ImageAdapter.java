package com.example.listview_test.ui.notifications;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.listview_test.R;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    public Integer[] images = {
            R.mipmap.beach4, R.mipmap.beach0,
            R.mipmap.beach0, R.mipmap.tree8,
            R.mipmap.beach4, R.mipmap.tree8
    };

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(240, 240));
        return imageView;
    }
}
