package com.example.androidscaffolding.ui.Auth

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle

import androidx.fragment.app.DialogFragment
import com.example.androidscaffolding.R

class OpeningDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                // Use the Builder class for convenient dialog construction.
                val builder = AlertDialog.Builder(it)
                builder.setMessage("계정이 있으신가요? 로그인 하시고 더 많은 기능을 사용해 보세요")
                    .setPositiveButton("로그인") { dialog, id ->
                        // START THE GAME!
                        val fragmentManager = activity?.supportFragmentManager
                        fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, LoginFragment())?.commit()
                    }
                    .setNegativeButton("일단 둘러보기") { dialog, id ->
                        // User cancelled the dialog.
                    }
                // Create the AlertDialog object and return it.
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }

}