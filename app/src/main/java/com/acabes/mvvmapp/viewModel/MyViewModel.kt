package com.acabes.mvvmapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.acabes.mvvmapp.model.HarryPotterCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MyViewModel :ViewModel(),CoroutineScope{
    private val job= Job()
    var hogwartsCharacters= MutableLiveData<List<HarryPotterCharacter>>()
    private val pageSize = 20

    fun display()  {
        try{
            launch {
                val api=RetrofitHelper().getInstance().create(APIinterface::class.java)
                val response=api.getDetails()
                hogwartsCharacters.value= response.body()
            }
        } catch(e: Exception){
            println("THE ERROR CAUGHT IS: \n ${e.message}")
        }
    }
    override val coroutineContext: CoroutineContext
        get()=job+ Dispatchers.Main
    override fun onCleared(){
        super.onCleared()
        job.cancel()
    }
}