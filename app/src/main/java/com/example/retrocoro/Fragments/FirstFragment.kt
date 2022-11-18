package com.example.retrocoro.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.retrocoro.Classes.result
import com.example.retrocoro.R
import com.example.retrocoro.ViewModel.viewMoDeL
import com.example.retrocoro.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: viewMoDeL by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.doTheWork(context)

        val nameObserver = Observer<List<result>> { newName ->
            // Update the UI, in this case, a TextView.
            binding.textView.text = newName.toString()
        }

        viewModel.primary.observe(this, nameObserver)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            binding.textView.text = viewModel.primary.value.toString()
        }



        binding.button3.setOnClickListener {

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}