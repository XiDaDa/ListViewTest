package com.example.listviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>
{
	private int resourceID;
	public FruitAdapter(Context content,int textViewResourceID,List<Fruit> objects)
	{
		super(content,textViewResourceID,objects);
		resourceID = textViewResourceID;
		
	}
	
	public View getView(int position,View convertView,ViewGroup parent)
	{
		Fruit fruit = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceID, null);
		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());
		return view;
	}

}
