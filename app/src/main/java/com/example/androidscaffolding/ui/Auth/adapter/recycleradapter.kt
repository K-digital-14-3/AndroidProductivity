package com.example.androidscaffolding.ui.Auth.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidscaffolding.databinding.AuthtaskRecyclerBinding

class TaskViewHolder(val binding : AuthtaskRecyclerBinding) : RecyclerView.ViewHolder(binding.root)
//LocalTodoFragmanet에 taskrecycler어뎁터
class recycleradapter (val datas : MutableList<String>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =TaskViewHolder(
       AuthtaskRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false))



    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as TaskViewHolder).binding
        binding.headlineView.text=datas[position]
    }

    fun addTask(task:String){
        datas.add(task)
        notifyItemInserted(datas.size-1)
    }
}