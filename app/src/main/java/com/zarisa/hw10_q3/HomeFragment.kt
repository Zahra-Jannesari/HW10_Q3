package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel:ViewModelHomeItems by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setItems()
    }
    private fun setItems(){
        binding.item1.textView.text=viewModel.getItemName(1)
        viewModel.getItemImage(requireContext(),binding.item1.imageView,1)
        binding.item2.textView.text=viewModel.getItemName(2)
        viewModel.getItemImage(requireContext(),binding.item2.imageView,2)
        binding.item3.textView.text=viewModel.getItemName(3)
        viewModel.getItemImage(requireContext(),binding.item3.imageView,3)
        binding.item4.textView.text=viewModel.getItemName(4)
        viewModel.getItemImage(requireContext(),binding.item4.imageView,4)
        binding.item5.textView.text=viewModel.getItemName(5)
        viewModel.getItemImage(requireContext(),binding.item5.imageView,5)
        binding.item6.textView.text=viewModel.getItemName(6)
        viewModel.getItemImage(requireContext(),binding.item6.imageView,6)
    }

}