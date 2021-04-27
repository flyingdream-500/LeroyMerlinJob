package com.example.leroymerlinjob.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.common.CategoryItem
import com.example.leroymerlinjob.common.CategoryItemSource
import com.example.leroymerlinjob.fragments.SubCategoriesFragment.Companion.CATEGORY_NAME
import kotlinx.android.synthetic.main.item_catalog_category_wide.view.*

class CatalogWideAdapter : RecyclerView.Adapter<CatalogWideAdapter.CatalogWideViewHolder>() {
    private var itemsList = CategoryItemSource.getItems()

    inner class CatalogWideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.cv_category_wide.setOnClickListener {
                if (isGardenItem()) {
                    Navigation.findNavController(itemView).navigate(R.id.subCategoriesFragment, subCategoryBundle())
                }
            }
        }

        private fun isGardenItem(): Boolean {
             itemsList[bindingAdapterPosition].let {
                 return it.name == "Сад"
            }
        }

        private fun subCategoryBundle(): Bundle {
            val bundle = Bundle()
            bundle.putString(CATEGORY_NAME, itemsList[bindingAdapterPosition].name)
            return bundle
        }


        fun bind(item: CategoryItem) {
            itemView.tv_category_wide_name.text = item.name
            Glide.with(itemView)
                .load(item.image)
                .into(itemView.iv_category_wide_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogWideViewHolder {
        return CatalogWideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog_category_wide, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatalogWideViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}