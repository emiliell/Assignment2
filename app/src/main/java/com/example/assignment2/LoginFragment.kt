package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class LoginFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = view.findViewById<EditText>(R.id.editTextTextUsername)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)

        val spinnerItems = listOf("footscray", "sydney", "br")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val campuses = view.findViewById<Spinner>(R.id.campus) // Or use View Binding
        campuses.adapter = adapter

        view.findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            val campus = campuses.selectedItem as String
            val userName = username.text.toString()
            val passWord = password.text.toString()






        }
    }


}