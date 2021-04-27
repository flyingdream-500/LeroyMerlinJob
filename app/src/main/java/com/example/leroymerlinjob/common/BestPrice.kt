package com.example.leroymerlinjob.common


import androidx.core.text.HtmlCompat.*
import com.example.leroymerlinjob.App.Companion.appContext
import com.example.leroymerlinjob.R
import java.util.ArrayList


data class ProductItem(
    val price: String,
    val description: String,
    val image: String
)

object ProductItemSource {
    fun getProducts() = ArrayList<ProductItem>().apply {
        add(ProductItem(appContext!!.resources.getString(R.string.first_product_price),
            appContext!!.resources.getString(R.string.first_product_description),
        "file:///android_asset/products/first_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.second_product_price),
            appContext!!.resources.getString(R.string.second_product_description),
            "file:///android_asset/products/second_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.third_product_price),
            appContext!!.resources.getString(R.string.third_product_description),
            "file:///android_asset/products/third_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.fourth_product_price),
            appContext!!.resources.getString(R.string.fourth_product_description),
            "file:///android_asset/products/fourth_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.fiveth_product_price),
            appContext!!.resources.getString(R.string.fiveth_product_description),
            "file:///android_asset/products/fiveth_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.sixth_product_price),
            appContext!!.resources.getString(R.string.sixth_product_description),
            "file:///android_asset/products/sixth_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.seventh_product_price),
            appContext!!.resources.getString(R.string.seventh_product_description),
            "file:///android_asset/products/seventh_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.eighth_product_price),
            appContext!!.resources.getString(R.string.eighth_product_description),
            "file:///android_asset/products/eighth_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.nineth_product_price),
            appContext!!.resources.getString(R.string.nineth_product_description),
            "file:///android_asset/products/ninth_product.jpg"))

        add(ProductItem(appContext!!.resources.getString(R.string.tenth_product_price),
            appContext!!.resources.getString(R.string.tenth_product_description),
            "file:///android_asset/products/tenth_product.jpg"))
    }

    fun getLimitProducts(): List<ProductItem> {
        return getProducts().reversed()
    }
}