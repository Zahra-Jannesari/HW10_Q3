package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding:FragmentSettingBinding
    val viewModelProfile:ViewModelProfile by viewModels()
    val viewModelItem:ViewModelHomeItems by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        setHasOptionsMenu(false)
        binding= FragmentSettingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.index_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerItem.adapter = adapter
        }
        setDataInEditTexts()
    }

    private fun setDataInEditTexts() {
        binding.name.setText(viewModelProfile.getUserName())
        binding.id.setText(viewModelProfile.getUserId())
        binding.phone.setText(viewModelProfile.getUserPhone())
        binding.address.setText(viewModelProfile.getUserAddress())
    }

}