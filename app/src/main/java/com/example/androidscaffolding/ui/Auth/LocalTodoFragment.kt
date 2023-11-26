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
    lateinit var adapter:recycleradapter
    lateinit var todoDatabaseHelper: TodoDatabaseHelper
    val dataList= mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpeningDialogFragment().show(childFragmentManager, "GAME_DIALOG")
        todoDatabaseHelper = TodoDatabaseHelper(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalTodoBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()

        binding.newTaskBtn.setOnClickListener {
            BottomSheet().show(childFragmentManager,BottomSheet().tag)
        }

        adapter = recycleradapter(dataList)

        binding.taskrecycler.adapter=adapter
        binding.taskrecycler.layoutManager = LinearLayoutManager(context)

        return binding.root

    }

    private fun setupRecyclerView() {
        val taskList = todoDatabaseHelper.getAllTasks()
        adapter = recycleradapter(taskList)
        binding.taskrecycler.adapter = adapter
        binding.taskrecycler.layoutManager = LinearLayoutManager(context)
        Log.d("LocalTodoFragment", "RecyclerView setup with ${taskList.size} tasks")
    }

    override fun onTaskAdded(task: String) {
        todoDatabaseHelper.addTask(task)
        adapter.addTask(task)
        Log.d("LocalTodoFragment", "Task added to UI: $task")
    }


}