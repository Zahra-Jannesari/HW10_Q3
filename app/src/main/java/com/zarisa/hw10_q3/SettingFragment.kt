package com.zarisa.hw10_q3

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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
        binding.saveChangeButton.setOnClickListener { saveChanges()}
    }

    private fun saveChanges() {
//        if(binding.switchTheme.isChecked)
        viewModelProfile.setUserName(binding.name.text.toString())
        viewModelProfile.setUserId(binding.id.text.toString())
        viewModelProfile.setUserPhone(binding.phone.text.toString())
        viewModelProfile.setUserAddress(binding.address.text.toString())
        binding.spinnerItem.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModelItem.numberOfItems=p2+1
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                viewModelItem.numberOfItems=4
            }
        }
        Toast.makeText(requireContext(),"Changes saved.",Toast.LENGTH_SHORT).show()
    }

    private fun setDataInEditTexts() {
        binding.name.setText(viewModelProfile.getUserName())
        binding.id.setText(viewModelProfile.getUserId().toString())
        binding.phone.setText(viewModelProfile.getUserPhone().toString())
        binding.address.setText(viewModelProfile.getUserAddress())
    }


}