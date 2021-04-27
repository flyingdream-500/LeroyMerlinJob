package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leroymerlinjob.R
import kotlinx.android.synthetic.main.subitem_catalog_subcategory.view.*

class SubCategorySubItemsAdapter:
    RecyclerView.Adapter<SubCategorySubItemsAdapter.SubCategorySubItemsViewHolder>() {

    private var listItem = List(10){"Садовая техника"}

    class SubCategorySubItemsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.tv_subcategory_subitem.text = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubCategorySubItemsViewHolder {

        return SubCategorySubItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.subitem_catalog_subcategory, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubCategorySubItemsViewHolder, position: Int) {
        holder.bind(listItem.get(position))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

}