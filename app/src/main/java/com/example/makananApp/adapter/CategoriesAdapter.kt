package com.example.makananApp.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.example.makananApp.Detail_Activity
import com.example.makananApp.databinding.ItemCategoriesBinding
import com.example.makananApp.model.KulinerItem


class CategoriesAdapter : RecyclerView.Adapter<CdvHeadLines>() {
    private val listNews:ArrayList<KulinerItem> = arrayListOf<KulinerItem>()
    fun addData(item: List<KulinerItem>){
        listNews.clear()
        listNews.addAll(item)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvHeadLines {
        val layoutInflater =LayoutInflater.from(parent.context)
        val binding =ItemCategoriesBinding.inflate(layoutInflater,parent,false)
        return CdvHeadLines(binding)


    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: CdvHeadLines, position: Int) {
        val data =listNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,Detail_Activity::class.java)
            intent.putExtra(Detail_Activity.date,data .nama)
            intent.putExtra(Detail_Activity.content,data .alamat)
            intent.putExtra(Detail_Activity.image,data .gambarUrl)
            intent.putExtra(Detail_Activity.jambuka,data .jamBukaTutup)
            it.context.startActivity(intent)

        }



    }
}

class CdvHeadLines(private val binding:ItemCategoriesBinding ) :RecyclerView.ViewHolder(binding.root){
    fun bind(item:KulinerItem) {
        with(binding) {
            tvCategory.text = item.nama
            ivImage.load(item.gambarUrl) {
                scale(Scale.FILL)
            }


        }
    }}
