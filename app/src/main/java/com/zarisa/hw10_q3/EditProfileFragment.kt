package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    lateinit var binding: FragmentEditProfileBinding
    private val viewModelProfile:ViewModelProfile by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "تغییر اطلاعات شخصی"
        setDataInEditTexts()
        binding.saveChangeButton.setOnClickListener {saveChanges()}
    }
    private fun setDataInEditTexts() {
        binding.name.setText(viewModelProfile.getUserName())
        binding.id.setText(viewModelProfile.getUserId().toString())
        binding.phone.setText(viewModelProfile.getUserPhone().toString())
        binding.address.setText(viewModelProfile.getUserAddress())
        binding.checkBoxInfoVisibilityInHome.isChecked=viewModelProfile.visibilityInfoInHome()
    }
    private fun saveChanges(){
        viewModelProfile.setUserName(binding.name.text.toString())
        viewModelProfile.setUserId(binding.id.text.toString())
        viewModelProfile.setUserPhone(binding.phone.text.toString())
        viewModelProfile.setUserAddress(binding.address.text.toString())
        Toast.makeText(requireContext(),"Changes saved.", Toast.LENGTH_SHORT).show()
        saveStateOfInfoVisibilityInHome()
    }
    private fun saveStateOfInfoVisibilityInHome() {
        viewModelProfile.visibilityInfoInHome(binding.checkBoxInfoVisibilityInHome.isChecked)
    }
}