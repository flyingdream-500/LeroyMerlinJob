package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.common.ProductItem
import com.example.leroymerlinjob.common.ProductItemSource
import com.example.leroymerlinjob.utils.getEditedPrice
import kotlinx.android.synthetic.main.item_product.view.*

class BestPriceProductsAdapter : RecyclerView.Adapter<BestPriceProductsAdapter.BestPriceProductsHolder>() {
    private var itemsList = ProductItemSource.getProducts()

    class BestPriceProductsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ProductItem) {

            itemView.tv_product_price.text = getEditedPrice(item.price)
            itemView.tv_product_description.text = item.description
            Glide.with(itemView)
                .load(item.image)
                .into(itemView.iv_product)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestPriceProductsHolder {
        return BestPriceProductsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BestPriceProductsHolder, position: Int) {
        holder.bind(itemsList.get(position))
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }




}