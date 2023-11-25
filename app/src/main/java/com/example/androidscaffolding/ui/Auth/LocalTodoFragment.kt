package com.example.androidscaffolding.ui.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidscaffolding.databinding.FragmentLocalTodoBinding
import com.example.androidscaffolding.ui.Auth.adapter.recycleradapter
import com.example.androidscaffolding.ui.Auth.fragment.BottomSheet


class LocalTodoFragment : Fragment() {
    lateinit var binding: FragmentLocalTodoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpeningDialogFragment().show(childFragmentManager, "GAME_DIALOG")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalTodoBinding.inflate(layoutInflater, container, false)

        binding.newTaskBtn.setOnClickListener {
            BottomSheet().show(childFragmentManager,BottomSheet().tag)
        }


        val datas= mutableListOf<String>()

        binding.taskrecycler.adapter=recycleradapter(datas)
        return binding.root








    }


}