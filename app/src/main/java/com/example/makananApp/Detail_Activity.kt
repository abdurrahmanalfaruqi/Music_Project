package com.example.makananApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import com.example.makananApp.adapter.CategoriesAdapter
import timber.log.Timber
import com.example.makananApp.databinding.ActivityDetailBinding


class Detail_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val rvAdapter = CategoriesAdapter()

    companion object {
        const val date = "date"
        const val content = "content"
        const val image = "image"
        const val jambuka = "jam buka"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        binding = ActivityDetailBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)


            val dates = intent.getStringExtra(date)
            val contents = intent.getStringExtra(content)
            val images = intent.getStringExtra(image)
            val jambuka = intent.getStringExtra(jambuka)


            tanggal.text = dates
            txtJam.text = jambuka
            txtcontent.text = contents
            imageViewdetail.load(images)
        }

    }

}