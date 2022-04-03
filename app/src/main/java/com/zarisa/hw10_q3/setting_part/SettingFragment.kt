package com.zarisa.hw10_q3.setting_part


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zarisa.hw10_q3.R
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
//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.index_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            binding.spinnerItem.adapter = adapter
//        }
        onClicks()
    }

    private fun onClicks() {
        saveChanges()
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
        if (binding.radio1.isChecked)
            numberOfVisible = 1
        if (binding.radio2.isChecked)
            numberOfVisible = 2
        if (binding.radio3.isChecked)
            numberOfVisible = 3
        if (binding.radio4.isChecked)
            numberOfVisible = 4
        if (binding.radio5.isChecked)
            numberOfVisible = 5
        if (binding.radio6.isChecked)
            numberOfVisible = 6
//        binding.spinnerItem.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                viewModelItem.numberOfItems=p2+1
//            }
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                viewModelItem.numberOfItems=4
//            }
//        }
//        HomeFragment.newInstance()
//        findNavController().navigate(R.id.action_nav_setting_to_nav_home)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.feature_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
        val changeItem = menu.findItem(R.id.changeTheme)
        changeItem.isVisible = true
    }
}