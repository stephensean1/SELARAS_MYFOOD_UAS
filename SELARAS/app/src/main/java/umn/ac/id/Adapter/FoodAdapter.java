package umn.ac.id.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import umn.ac.id.R;
import umn.ac.id.Models.Food;

public class FoodAdapter extends ArrayAdapter<Food> {

    //Melakukan konstruktor untuk pertama kali
    public FoodAdapter(Activity context, ArrayList<Food>foods) {
        super(context, 0, foods);
    }

    //mengambil view
    public View getView(int position, View convertView, ViewGroup parent) {
        //membaca view yang akan diisi, menggunakan listview
        View listItemView = convertView;

        //jika lisk kosong, akan terisi oleh list_item.xml
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Food currentFood = getItem(position);
        TextView foodNameTextView = (TextView)listItemView.findViewById(R.id.food_name);

        foodNameTextView.setText(currentFood.getFoodName());

        //convert int price
        TextView priceTextView = (TextView)listItemView.findViewById(R.id.price);
        priceTextView.setText(Integer.toString(currentFood.getFoodPrice()));

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);

        imageView.setImageResource(currentFood.getmImageResouce());

        imageView.setVisibility(View.VISIBLE);
        return listItemView;
    }
}
