package umn.ac.id.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import umn.ac.id.Models.Fav;
import umn.ac.id.R;

public class FavListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Fav> favArrayList;

    public FavListAdapter(Context context, int layout, ArrayList<Fav> foodsList) {
        this.context = context;
        this.layout = layout;
        this.favArrayList = foodsList;
    }
    @Override
    public int getCount() {
        return favArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return favArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView txtName, txtQuantity, txtPrice;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = (TextView)row.findViewById(R.id.txtName);
            holder.txtQuantity = (TextView)row.findViewById(R.id.txtQuantity);
            holder.txtPrice = (TextView)row.findViewById(R.id.txtPrice);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Fav food = favArrayList.get(position);
        holder.txtName.setText(food.getName());
        holder.txtQuantity.setText(food.getQuantity());
        holder.txtPrice.setText(food.getPrice());
        return row;
    }
}
