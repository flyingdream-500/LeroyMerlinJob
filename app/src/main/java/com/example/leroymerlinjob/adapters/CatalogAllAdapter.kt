package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.leroymerlinjob.R

import kotlinx.android.synthetic.main.item_catalog_all.view.*

class CatalogAllAdapter : RecyclerView.Adapter<CatalogAllAdapter.CatalogAllHolder>() {

    class CatalogAllHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.cv_category_all.setOnClickListener {
                //open catalog fragment
                Navigation.findNavController(itemView).navigate(R.id.catalogWideFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogAllHolder {
        return CatalogAllHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog_all, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatalogAllHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}