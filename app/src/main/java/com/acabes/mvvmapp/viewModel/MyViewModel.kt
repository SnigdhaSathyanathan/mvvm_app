package com.acabes.mvvmapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.acabes.mvvmapp.model.HarryPotterCharacter

class MyViewModel :ViewModel() {

    var hogwartsCharacters= MutableLiveData<List<HarryPotterCharacter>>()
    fun display()  {
        try{
            GlobalScope.launch {
                val api=RetrofitHelper().getInstance().create(APIinterface::class.java)
                val response=api.getDetails()
                println("Got Detailsssssssssss ${response}")
                hogwartsCharacters.value= response.body()
            }
        } catch(e: Exception){
            println("THE ERROR CAUGHT IS: \n ${e.message}")
        }
    }
}