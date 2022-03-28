package com.zarisa.hw10_q3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zarisa.hw10_q3.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {
    private lateinit var binding: FragmentCreditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCreditBinding.inflate(layoutInflater,container, false)
        return binding.root
    }
}