package com.example.androidscaffolding.ui.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentLocalTodoBinding
import com.example.androidscaffolding.ui.Auth.adapter.recycleradapter
import com.example.androidscaffolding.ui.Auth.fragment.BottomSheet


class LocalTodoFragment : Fragment() {
    lateinit var binding: FragmentLocalTodoBinding
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalTodoBinding.inflate(layoutInflater, container, false)
        return binding.root

        val datas= mutableListOf<String>()

        binding.taskrecycler.adapter=recycleradapter(datas)


        binding.newTaskBtn.setOnClickListener {
            BottomSheet().show(childFragmentManager,"newTask")
        }
    }


}