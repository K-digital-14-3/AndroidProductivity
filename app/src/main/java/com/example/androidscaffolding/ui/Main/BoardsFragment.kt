package com.example.androidscaffolding.ui.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.databinding.FragmentBoardsBinding


class BoardsFragment : Fragment() {
    private var mBinding : FragmentBoardsBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBoardsBinding.inflate(inflater, container, false)
        mBinding = binding

        val button = binding.addListFAB
        button.setOnClickListener { view ->
            val bottomSheet = BBSFragment()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }


        return  mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}