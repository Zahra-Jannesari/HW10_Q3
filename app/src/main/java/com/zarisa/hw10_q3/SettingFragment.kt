package com.zarisa.hw10_q3


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
        setHasOptionsMenu(true)
        binding= FragmentSettingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.index_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            binding.spinnerItem.adapter = adapter
//        }
        setDataInEditTexts()
        binding.saveChangeButton.setOnClickListener { saveChanges()}
    }

    private fun saveChanges() {
        viewModelProfile.setUserName(binding.name.text.toString())
        viewModelProfile.setUserId(binding.id.text.toString())
        viewModelProfile.setUserPhone(binding.phone.text.toString())
        viewModelProfile.setUserAddress(binding.address.text.toString())
        if (binding.radio1.isChecked)
            numberOfVisible=1
        if (binding.radio2.isChecked)
            numberOfVisible=2
        if (binding.radio3.isChecked)
            numberOfVisible=3
        if (binding.radio4.isChecked)
            numberOfVisible=4
        if (binding.radio5.isChecked)
            numberOfVisible=5
        if (binding.radio6.isChecked)
            numberOfVisible=6
//        binding.spinnerItem.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                viewModelItem.numberOfItems=p2+1
//            }
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                viewModelItem.numberOfItems=4
//            }
//        }
        Toast.makeText(requireContext(),"Changes saved.",Toast.LENGTH_SHORT).show()
//        HomeFragment.newInstance()
//        findNavController().navigate(R.id.action_nav_setting_to_nav_home)
    }

    private fun setDataInEditTexts() {
        binding.name.setText(viewModelProfile.getUserName())
        binding.id.setText(viewModelProfile.getUserId().toString())
        binding.phone.setText(viewModelProfile.getUserPhone().toString())
        binding.address.setText(viewModelProfile.getUserAddress())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
        val changeItem = menu.findItem(R.id.changeTheme)
        changeItem.isVisible = true
    }
}