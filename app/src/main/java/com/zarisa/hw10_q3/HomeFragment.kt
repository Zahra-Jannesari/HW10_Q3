package com.zarisa.hw10_q3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zarisa.hw10_q3.databinding.FragmentHomeBinding


const val numberOfItem = "numberOfItem"
var numberOfVisible = 4

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: ViewModelHomeItems by viewModels()
    private val viewModelProfile: ViewModelProfile by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setItems()
        setVisibilityForItems()
        onClicks()
        setInfo()
    }

    @SuppressLint("SetTextI18n")
    private fun setInfo() {
        binding.textViewGreeting.text = "سلام ${viewModelProfile.getUserName()}"
        if (viewModelProfile.getUserName().isBlank() && viewModelProfile.getUserId()
                .isBlank() && viewModelProfile.getUserPhone()
                .isBlank() && viewModelProfile.getUserAddress().isBlank()
        ) binding.textViewInfo.text = "شما هنوز مشخصات خود را ثبت نکرده اید."
        else {
            if (viewModelProfile.visibilityInfoInHome()) {
                binding.textViewInfo.text =
                    "مشخصات ذخیره شده شما در اپلیکیشن گردشگری:\nکدملی:${viewModelProfile.getUserId()}\n" +
                            "تلفن:${viewModelProfile.getUserPhone()}\n" +
                            "آدرس:${viewModelProfile.getUserAddress()}"
            } else
                binding.textViewInfo.text = "مشخصات شما در صفحه پروفایل قابل مشاهده است."
        }
    }

    private fun setVisibilityForItems() {
        for (i in 1..6) {
            val viewId =
                requireContext().resources.getIdentifier("item$i", "id", context?.packageName)
            var itemView = view?.findViewById<View>(viewId)
            itemView?.visibility = View.VISIBLE
        }
        for (i in numberOfVisible + 1..6) {
            val viewId =
                requireContext().resources.getIdentifier("item$i", "id", context?.packageName)
            var itemView = view?.findViewById<View>(viewId)
            itemView?.visibility = View.GONE
        }
    }

    private fun onClicks() {
        binding.item1.imageView.setOnClickListener { goToDetailPage(1) }
        binding.item2.imageView.setOnClickListener { goToDetailPage(2) }
        binding.item3.imageView.setOnClickListener { goToDetailPage(3) }
        binding.item4.imageView.setOnClickListener { goToDetailPage(4) }
        binding.item5.imageView.setOnClickListener { goToDetailPage(5) }
        binding.item6.imageView.setOnClickListener { goToDetailPage(6) }
        val snackBarColor =
            if (appTheme == R.style.Theme_HW10_Q3) R.color.teal_700 else R.color.orange_yellow
        binding.fabDailyHint.setOnClickListener { view ->
            Snackbar.make(view, "${viewModel.getHint()}", Snackbar.LENGTH_LONG).setAction("Action", null)
                .setBackgroundTint(resources.getColor(snackBarColor)).show()
//            ViewCompat.setLayoutDirection(Snackbar.getView(),ViewCompat.LAYOUT_DIRECTION_RTL);
//            Snackbar.show();
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                val snack: View = Snackbar.View()
//                snack.layoutDirection = View.LAYOUT_DIRECTION_RTL
//            }
//
//            Snackbar.show()
        }
    }

    private fun goToDetailPage(itemNumber: Int) {
        val bundle = bundleOf(numberOfItem to itemNumber)
        findNavController().navigate(R.id.action_nav_home_to_itemDetailFragment, bundle)
    }

    private fun setItems() {
        var itemArray = arrayListOf(
            binding.item1,
            binding.item2,
            binding.item3,
            binding.item4,
            binding.item5,
            binding.item6
        )
        for (i in 1..itemArray.size) {
            itemArray[i - 1].textView.text = viewModel.getItemName(i)
            viewModel.getItemImage(requireContext(), itemArray[i - 1].imageView, i)
        }
//        binding.item1.textView.text = viewModel.getItemName(1)
//        viewModel.getItemImage(requireContext(), binding.item1.imageView, 1)
//        binding.item2.textView.text = viewModel.getItemName(2)
//        viewModel.getItemImage(requireContext(), binding.item2.imageView, 2)
//        binding.item3.textView.text = viewModel.getItemName(3)
//        viewModel.getItemImage(requireContext(), binding.item3.imageView, 3)
//        binding.item4.textView.text = viewModel.getItemName(4)
//        viewModel.getItemImage(requireContext(), binding.item4.imageView, 4)
//        binding.item5.textView.text = viewModel.getItemName(5)
//        viewModel.getItemImage(requireContext(), binding.item5.imageView, 5)
//        binding.item6.textView.text = viewModel.getItemName(6)
//        viewModel.getItemImage(requireContext(), binding.item6.imageView, 6)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.feature_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
        val accessCreditPage = menu.findItem(R.id.accessCreditPage)
        accessCreditPage.isVisible = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.accessCreditPage -> findNavController().navigate(R.id.action_nav_home_to_creditFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}