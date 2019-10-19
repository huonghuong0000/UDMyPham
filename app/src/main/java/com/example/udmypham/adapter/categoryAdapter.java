package com.example.udmypham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.udmypham.R;
import com.example.udmypham.model.category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class categoryAdapter extends BaseAdapter {
    ArrayList<category> arrcategory;
    Context context;
    @Override
    public int getCount() {
        return arrcategory.size();
    }

    @Override
    public Object getItem(int i) {
        return arrcategory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        TextView txtCategory;
        ImageView imagCategory;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_category, null);
            viewHolder.txtCategory = view.findViewById(R.id.txtLoaiSP);
            viewHolder.imagCategory = view.findViewById(R.id.imageCategory);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
            category category = (category) getItem(i);
            viewHolder.txtCategory.setText(category.getTenloaisp());
        }
        return null;
    }
}
