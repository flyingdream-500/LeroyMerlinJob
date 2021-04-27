package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.common.SubCategory
import com.example.leroymerlinjob.common.SubCategorySource
import kotlinx.android.synthetic.main.item_catalog_subcategory.view.*

class SubCategoryAdapter(val scrollListener: SubCategoryScrollListener)
    : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder>() {

    private var itemsList: ArrayList<SubCategory> = SubCategorySource.getSubCategories()

    interface SubCategoryScrollListener {
        fun scrollToPosition(position: Int)
    }

    inner class SubCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.cv_catalog_subcategory.setOnClickListener {
                val item = itemsList.get(bindingAdapterPosition)

                setupSubItemRecyclerView()

                if(!item.dropped) {
                    showSubItems()
                } else {
                    hideSubItems()
                }

                item.dropped = !item.dropped

            }
        }

        private fun setupSubItemRecyclerView() {
            itemView.rv_subitems.layoutManager = LinearLayoutManager(itemView.context)
            itemView.rv_subitems.adapter = SubCategorySubItemsAdapter()
        }

        private fun showSubItems() {
            itemView.iv_subcategory_image.animate().rotation(180f).start()
            itemView.rv_subitems.visibility = View.VISIBLE

            //
            scrollListener.scrollToPosition(bindingAdapterPosition)
        }

        private fun hideSubItems() {
            itemView.iv_subcategory_image.animate().rotation(0f).start()
            itemView.rv_subitems.visibility = View.GONE
        }

        fun bind(item: SubCategory) {
            itemView.tv_subcategory_name.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryHolder {
        return SubCategoryHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog_subcategory, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubCategoryHolder, position: Int) {
        holder.bind(itemsList.get(position))
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

}