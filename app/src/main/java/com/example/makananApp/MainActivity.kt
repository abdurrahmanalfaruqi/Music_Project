package com.example.makananApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makananApp.adapter.CategoriesAdapter
import com.example.makananApp.databinding.ActivityMainBinding
import com.example.makananApp.model.*
import com.example.makananApp.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter =CategoriesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)

            mainRv.adapter = rvAdapter
            mainRv.layoutManager = LinearLayoutManager(baseContext)
            mainRv.setHasFixedSize(true)
        }
        val call = RetrofitBuilder.getService().fetchHeadlines()
        call.enqueue(object :Callback<Makanan>{
            override fun onFailure(call: Call <Makanan>, t:Throwable) {
                Timber.e(t.localizedMessage)
            }

            override fun onResponse(call: Call<Makanan>, response: Response<Makanan>) {
                val listArticlesItem = response.body()?.kuliner
                listArticlesItem.let { rvAdapter.addData(it as List<KulinerItem>)
                }
            }
        })



    }
    }
