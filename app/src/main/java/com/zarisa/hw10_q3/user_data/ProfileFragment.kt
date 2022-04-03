package com.zarisa.hw10_q3.user_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.ViewModelProfile
import com.zarisa.hw10_q3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val viewModel: ViewModelProfile by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(false)
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        binding.textViewUserName.text = viewModel.getUserName()
        binding.textViewUserId.text = viewModel.getUserId().toString()
        binding.textViewUserPhone.text = viewModel.getUserPhone().toString()
        binding.textViewUserAddress.text = viewModel.getUserAddress()
        viewModel.getPhoto(requireContext(), binding.imageView)
    }
}