package com.example.assignment2.ui.recyclerview

import dagger.hilt.android.AndroidEntryPoint


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.network.ResponseItem
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var navigationFunctionLambda: (ResponseItem) -> Unit
    private lateinit var recyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationFunctionLambda = {
            findNavController().navigate(
                DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment()
            )
        }
        recyclerViewAdapter = MyRecyclerViewAdapter(navigationFunction = navigationFunctionLambda)


        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.apiResponseObjects.collect { listOfResponseItems ->
                    recyclerViewAdapter.setData(listOfResponseItems)
                }
            }
        }

        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = recyclerViewAdapter
    }

}