package com.febrian.latihanretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.febrian.latihanretrofit.databinding.ItemsBinding

class DataAdapter(private val list : ArrayList<DataResponse>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private lateinit var binding : ItemsBinding

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
       val binding = ItemsBinding.bind(view)

        fun bind(data : DataResponse){
            with(binding){
                binding.title.text = data.title
                binding.title.text = data.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}