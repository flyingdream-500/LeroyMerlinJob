package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.leroymerlinjob.R
import kotlinx.android.synthetic.main.item_catalog.view.*

class CatalogAdapter() : RecyclerView.Adapter<CatalogAdapter.CatalogHolder>() {


    class CatalogHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.cv_catalog.setOnClickListener {
                //open catalog fragment
                Navigation.findNavController(itemView).navigate(R.id.catalogWideFragment)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogHolder {
        return CatalogHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog,parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatalogHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}