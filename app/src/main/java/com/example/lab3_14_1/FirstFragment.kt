package com.example.lab3_14_1

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonNavigate)
        // Điều hướng đến SecondFragment khi nút được nhấn
//        button.setOnClickListener {
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
//        }

        button.setOnClickListener {
            // Hiển thị Dialog xác nhận
            AlertDialog.Builder(requireContext())
                .setTitle("Confirm Navigation")
                .setMessage("Do you want to go to the next screen?")
                .setPositiveButton("Yes") { dialog, _ ->
                    // Điều hướng nếu nhấn "Yes"

                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                    Snackbar.make(view, "Navigating to second screen",
                        Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }

}