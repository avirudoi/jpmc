package com.example.jpmc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jpmc.adapter.SchoolsListAdapter
import com.example.jpmc.data.School
import com.example.jpmc.databinding.SchoolListFragmentBinding
import com.example.jpmc.viewmodel.DisplaySchoolsViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class SchoolsListFragment : Fragment() {

    private var _binding: SchoolListFragmentBinding? = null
    private val displaySchoolsViewModel: DisplaySchoolsViewModel by viewModels()
    private lateinit var adapter: SchoolsListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SchoolListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        displaySchoolsViewModel.apply {
            schools.observe(viewLifecycleOwner, Observer {
                adapter.updateItems(it)
            })
        }
    }

    private fun setRecyclerViewLinearLayoutManager() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.recycleChildrenOnDetach = true
        layoutManager.initialPrefetchItemCount = 10
        binding.list.layoutManager = layoutManager
    }

    private fun initAdapter() {
        adapter = SchoolsListAdapter(
            onItemClicked = {
                navigateToSchoolDetail(it)
            },
        )
        binding.list.adapter = adapter
        setRecyclerViewLinearLayoutManager()
    }

    private fun navigateToSchoolDetail(school: School) {
        val direction =
            SchoolsListFragmentDirections.actionSchoolsListFragmentToSchoolDetailDialogFragment(school.dbn)
        findNavController().navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}