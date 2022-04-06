package com.zarisa.hw10_q3.setting_part


import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zarisa.hw10_q3.R
import com.zarisa.hw10_q3.appTheme
import com.zarisa.hw10_q3.databinding.FragmentSettingBinding
import com.zarisa.hw10_q3.numberOfVisible

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        primaryInitForSpinners()
        onClicks()
    }

    private fun primaryInitForSpinners() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.index_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerItems.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.theme_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTheme.adapter = adapter
        }
        binding.spinnerItems.setSelection(numberOfVisible - 1)
        binding.spinnerTheme.setSelection(
            when (appTheme) {
                R.style.pink_theme -> 1
                R.style.green_theme -> 2
                else -> 0
            }
        )
    }

    private fun onClicks() {
        saveChanges()
        binding.saveChangeButton.setOnClickListener {
            activity?.recreate() }
        binding.bottomMenu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.editCredit -> {
                    findNavController().navigate(R.id.action_nav_setting_to_editCreditFragment)
                    true
                }
                R.id.editProfile -> {
                    findNavController().navigate(R.id.action_nav_setting_to_editProfileFragment)
                    true
                }
                else -> true
            }
        }
    }

    private fun saveChanges() {
//        if (binding.radio1.isChecked)
//            numberOfVisible = 1
//        if (binding.radio2.isChecked)
//            numberOfVisible = 2
//        if (binding.radio3.isChecked)
//            numberOfVisible = 3
//        if (binding.radio4.isChecked)
//            numberOfVisible = 4
//        if (binding.radio5.isChecked)
//            numberOfVisible = 5
//        if (binding.radio6.isChecked)
//            numberOfVisible = 6
        binding.spinnerItems.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                numberOfVisible=when(p0?.getItemAtPosition(p2).toString()){
                    "1"->1
                    "2"->2
                    "3"->3
                    "5"->5
                    "6"->6
                    else->4
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                numberOfVisible=4
            }
        }
//        HomeFragment.newInstance()
//        findNavController().navigate(R.id.action_nav_setting_to_nav_home)
        binding.spinnerTheme.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                appTheme=when(p0?.getItemAtPosition(p2).toString()){
                    "صورتی"->R.style.pink_theme
                    "سبز"->R.style.green_theme
                    else->R.style.Theme_HW10_Q3
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                appTheme=R.style.Theme_HW10_Q3
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.feature_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//        val changeItem = menu.findItem(R.id.changeTheme)
//        changeItem.isVisible = true
//    }
}