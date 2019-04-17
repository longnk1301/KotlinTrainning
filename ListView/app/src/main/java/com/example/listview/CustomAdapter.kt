package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (var context: Context, var foods: ArrayList<Foods>) : BaseAdapter() {
    class ViewHolder(row : View) {
        var textViewFoodName: TextView
        var imageViewFood: ImageView
        var priceViewFood: TextView

        init {
            textViewFoodName = row.findViewById(R.id.foodName) as TextView
            imageViewFood = row.findViewById(R.id.imageFood) as ImageView
            priceViewFood = row.findViewById(R.id.price) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.line_food, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        var food: Foods = getItem(position) as Foods
        viewHolder.textViewFoodName.text = food.name
        viewHolder.imageViewFood.setImageResource(food.image)
        viewHolder.priceViewFood.text = food.price

        return view as View
    }

    override fun getItem(position: Int): Any {
        return foods.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return foods.size
    }

}