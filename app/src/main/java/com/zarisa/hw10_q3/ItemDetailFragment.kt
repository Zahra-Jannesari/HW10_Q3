package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentItemDetailBinding

class ItemDetailFragment : Fragment() {
    var numberOfSelectedItem=0
    val viewModel:ViewModelHomeItems by viewModels()
    lateinit var binding: FragmentItemDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentItemDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        binding.ItemName.text=viewModel.getItemName(numberOfSelectedItem)
        viewModel.getItemFullImage(requireContext(),binding.ItemImage,numberOfSelectedItem)
        binding.ItemDescribe.text=viewModel.getItemDescribe(numberOfSelectedItem)
    }
}