package com.example.jpmc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.jpmc.data.SchoolInfo
import com.example.jpmc.databinding.SchoolInfoFragmentBinding
import com.example.jpmc.viewmodel.SchoolInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SchoolDetailDialogFragment : DialogFragment() {

    private var _binding:SchoolInfoFragmentBinding? = null
    private val schoolsViewModel: SchoolInfoViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SchoolInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schoolsViewModel.apply {
           schoolInfo.observe(viewLifecycleOwner, Observer {
                displaySchoolDetails(it)
            })
        }
    }

    private fun displaySchoolDetails(info:SchoolInfo){
        binding.textName.text = info.schoolName
        binding.textNumOfTestTakers.text = context?.getString(R.string.num_of_test_takers,info.testTakers)
        binding.textCriticalReadingAvgScore.text = context?.getString(R.string.reading_avg_score,info.readingAvgScore)
        binding.textMathAvgScore.text = context?.getString(R.string.math_avg_score,info.mathAvgScore)
        binding.textWritingAvgScore.text = context?.getString(R.string.writing_avg_score,info.writingAvgScore)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
