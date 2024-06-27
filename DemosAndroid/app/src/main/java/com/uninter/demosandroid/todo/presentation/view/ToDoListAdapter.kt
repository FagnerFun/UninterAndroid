package com.uninter.demosandroid.todo.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninter.demosandroid.R
import com.uninter.demosandroid.todo.domain.entity.ToDo

class ToDoListAdapter(val items: List<ToDo>): RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(item: ToDo){
            with(itemView)
            {
                item.let {

//                    findViewById<CardView>(R.id.cardLayout).setBackgroundColor(Color.parseColor(it.hexColor))
                    findViewById<TextView>(R.id.txtToDoTitle).text = it.title
                    if(it.isCompleted)
                        findViewById<ImageView>(R.id.imgIsCompleted).setImageResource(android.R.drawable.checkbox_on_background)
                    else
                        findViewById<ImageView>(R.id.imgIsCompleted).setImageResource(android.R.drawable.checkbox_off_background)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var toDo = items[position]
        holder.bindView(toDo)
    }
}