package com.acabes.mvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acabes.mvvmapp.R
import com.acabes.mvvmapp.viewModel.APIinterface
import com.acabes.mvvmapp.viewModel.MyAdapter
import com.acabes.mvvmapp.viewModel.MyViewModel
import com.acabes.mvvmapp.viewModel.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var viewmodel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewmodel.display()
        viewmodel.hogwartsCharacters.observe(this) { result ->
            var adapter = MyAdapter(result)
            recyclerView.adapter = adapter
        }


    }
}
