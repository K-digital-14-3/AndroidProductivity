package com.example.androidscaffolding.ui.Auth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.FragmentIntroBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val loginStartButton: Button = view.findViewById(R.id.fragment_login)

        loginStartButton.setOnClickListener {

            // LoginFragment 로의 Transaction 수행
            fragmentManager?.beginTransaction()

                ?.replace(R.id.fragment_login, LoginFragment())
                ?.addToBackStack(null)

                // 변경사항 저장 + 화면에 반영
                ?.commit()

        }

    }
}






