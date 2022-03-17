package com.zarisa.hw10_q3

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.databinding.FragmentItemDetailBinding


class ItemDetailFragment : Fragment() {
    var numberOfSelectedItem=0
    var itemTitle:String=""
    var itemText=""
    val viewModel:ViewModelHomeItems by viewModels()
    lateinit var binding: FragmentItemDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding= FragmentItemDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        numberOfSelectedItem=requireArguments().getInt(numberOfItem)
        itemTitle=viewModel.getItemName(numberOfSelectedItem)
        itemText=viewModel.getItemDescribe(requireActivity(),numberOfSelectedItem)
        (activity as AppCompatActivity).supportActionBar?.title = itemTitle
        binding.ItemName.text=itemTitle
        viewModel.getItemFullImage(requireContext(),binding.ItemImage,numberOfSelectedItem)
        binding.ItemDescribe.text =itemText
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
        val shareItem = menu.findItem(R.id.shareItem)
        shareItem.isVisible = true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shareItem-> shareTheDetails()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareTheDetails() {
        var myIntent = Intent(Intent.ACTION_SEND)
        myIntent.type = "text/plain"
        var shareText = "$itemTitle:\n$itemText"
        myIntent.putExtra(Intent.EXTRA_TEXT, shareText)
        startActivity(Intent.createChooser(myIntent, "Share with:"))
    }
}