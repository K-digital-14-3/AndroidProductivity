package com.example.androidscaffolding.ui.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    lateinit var binding :FragmentIntroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.todoStart.setOnClickListener {
            // LocalTodoFragment 로 프래그먼트 트랜잭션 수행
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, LocalTodoFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}

