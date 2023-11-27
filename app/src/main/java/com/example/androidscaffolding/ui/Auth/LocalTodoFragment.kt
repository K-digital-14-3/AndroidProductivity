package com.example.androidscaffolding.ui.Auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidscaffolding.databinding.FragmentLocalTodoBinding
import com.example.androidscaffolding.ui.Auth.adapter.TodoDatabaseHelper
import com.example.androidscaffolding.ui.Auth.adapter.recycleradapter
import com.example.androidscaffolding.ui.Auth.fragment.BottomSheet
import com.example.androidscaffolding.ui.Auth.fragment.BottomSheetListener


class LocalTodoFragment : Fragment(), BottomSheetListener {
    lateinit var binding: FragmentLocalTodoBinding
    lateinit var todoDatabaseHelper: TodoDatabaseHelper
    lateinit var adapter: recycleradapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpeningDialogFragment().show(childFragmentManager, "GAME_DIALOG")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalTodoBinding.inflate(layoutInflater, container, false)


        // RecyclerView 및 Adapter 초기화
        val db = TodoDatabaseHelper(requireContext())
        val tasks = db.allData  // 데이터베이스에서 데이터를 가져옵니다
        val adapter = recycleradapter(tasks)  // tasks는 List<String>이라고 가정
        binding.taskrecycler.layoutManager = LinearLayoutManager(context)
        binding.taskrecycler.adapter = adapter


        binding.newTaskBtn.setOnClickListener {
            BottomSheet().show(childFragmentManager,BottomSheet().tag)

        }
        return binding.root
    }

    override fun onTaskAdded() {

    }

}