package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.assignment2.data.RepClass
import com.example.assignment2.ui.recyclerview.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject lateinit var repo: RepClass
    private val loginviewModel: LoginViewModel by viewModels()

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

            viewLifecycleOwner.lifecycleScope.launch {

                loginviewModel.login(campus, userName, passWord)

                val error = loginviewModel.loginError.value

                if (error != null) {
                    Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
                }
                else {
                    val res = repo.login(campus, userName, passWord)
                    findNavController().navigate(
                        R.id.action_loginFragment_to_dashboardFragment,
                        bundleOf("keypass" to res.keypass, "campus" to campus)
                    )
                }


            }

        }
    }


}