package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListShoesBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class ListShoeFragment : Fragment() {
    private lateinit var binding: FragmentListShoesBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_list_shoes, container, false)
        setHasOptionsMenu(true)
        viewModel.Shoes.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addView(shoe)
            }
        }
        binding.addShoe.setOnClickListener {
            it.findNavController()
                .navigate(ListShoeFragmentDirections.actionListShoeFragmentToAddShoeFragment())
        }
        return binding.root
    }

    private fun addView(shoe: Shoe) {
        val itemBinding: ItemShoeBinding = ItemShoeBinding.inflate(layoutInflater)
        itemBinding.shoeItem = shoe
        binding.listOfShoes.addView(itemBinding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
