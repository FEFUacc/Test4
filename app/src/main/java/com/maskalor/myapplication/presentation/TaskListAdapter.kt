package com.maskalor.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.maskalor.myapplication.R
import com.maskalor.myapplication.domain.models.Task

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.MyViewHolder>(MyDiffUtil()) {

    class MyViewHolder(view: View) : ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LinearLayout.inflate(parent.context, R.layout.task_layout, parent.)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = currentList[position].name
    }
}