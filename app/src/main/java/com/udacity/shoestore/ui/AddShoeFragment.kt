package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel

class AddShoeFragment : Fragment() {
    private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_shoe, container, false)

        binding.shoeVM = viewModel
        viewModel.Clear()

        binding.saveShoe.setOnClickListener {
            if (viewModel.dataValid()) {
                viewModel.addNewShoe()
                it.findNavController()
                    .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToListShoeFragment())
                Toast.makeText(context, "Shoe is saved successfully !!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Missing Data !!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.cancel.setOnClickListener {
            it.findNavController()
                .navigate(AddShoeFragmentDirections.actionAddShoeFragmentToListShoeFragment())
        }

        return binding.root
    }


}