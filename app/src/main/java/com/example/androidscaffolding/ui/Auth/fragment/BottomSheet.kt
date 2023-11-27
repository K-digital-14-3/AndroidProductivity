package com.example.androidscaffolding.ui.Auth.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidscaffolding.databinding.FragmentBottomSheetBinding
import com.example.androidscaffolding.ui.Auth.adapter.TodoDatabaseHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBottomSheetBinding
    var listener : BottomSheetListener? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        binding.saveButton.setOnClickListener {
            val task = binding.headline.text.toString()  // 실제 입력 필드에 맞게 조정
            val taskDesc = binding.desc.text.toString()  // 이 부분도 조정

            val db = TodoDatabaseHelper(requireContext())
            db.addData(task, taskDesc)
            dismiss()
        }
        return binding.root
    }
}