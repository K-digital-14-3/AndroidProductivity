package com.example.androidscaffolding.ui.Main

import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentBBSBinding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class BBSFragment : BottomSheetDialogFragment() {


    private var bottomSheetBinding: FragmentBBSBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bottomSheetBinding = FragmentBBSBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_b_b_s, container, false)
    }


}