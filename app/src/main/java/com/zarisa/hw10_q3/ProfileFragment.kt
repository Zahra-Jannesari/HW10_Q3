package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    val viowModel:ViewModelProfile by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(false)
        binding = FragmentProfileBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        binding.textViewUserName.text=viowModel.getUserName()
        binding.textViewUserId.text=viowModel.getUserId().toString()
        binding.textViewUserPhone.text=viowModel.getUserPhone().toString()
        binding.textViewUserAddress.text=viowModel.getUserAddress()
        viowModel.getPhoto(requireContext(),binding.imageView)
    }
}