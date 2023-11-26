package com.example.androidscaffolding.ui.Auth.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidscaffolding.databinding.FragmentBottomSheetBinding
import com.example.androidscaffolding.ui.Auth.adapter.TodoDatabaseHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet : BottomSheetDialogFragment() {
    lateinit var binding : FragmentBottomSheetBinding
    var listener : BottomSheetListener? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater,container,false)

        binding.saveButton.setOnClickListener {
            val headline = binding.headline.text.toString()
            if (headline.isNotEmpty()) {
                listener?.onTaskAdded(headline)
                dismiss()
            }
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BottomSheetListener) {
            listener = context
        }

    }
}