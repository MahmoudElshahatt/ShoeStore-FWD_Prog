package com.udacity.shoestore.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = mutableListOf()
    }

    val Shoes: LiveData<MutableList<Shoe>>
        get() = shoeList

    var shoeName: String = ""
    var shoeDescription: String = ""
    var shoeSize: String = ""
    var shoeCompany: String = ""

    fun Clear() {
        shoeName = ""
        shoeDescription = ""
        shoeSize = ""
        shoeCompany = ""
    }

    fun addNewShoe(): Boolean {
        addShoe(
            shoeName,
            shoeSize.toDouble(),
            shoeCompany,
            shoeDescription
        )

        return true
    }

    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description, R.drawable.shoe_img)
        shoeList.value!!.add(shoe)
        Log.i("viewModel", "shoe is saved into livedata List")
    }

    fun dataValid(): Boolean {
        if (shoeName.isBlank() || shoeSize.isBlank() ||
            shoeCompany.isBlank() ||
            shoeDescription.isBlank()
        ) {
            return false
        }
        return true
    }

}