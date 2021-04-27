package com.example.leroymerlinjob.common

import com.example.leroymerlinjob.App.Companion.appContext
import com.example.leroymerlinjob.R

data class CategoryItem(
    val name: String,
    val image: String
    )

object CategoryItemSource {
    fun getItems() = ArrayList<CategoryItem>().apply {
        add(CategoryItem(appContext!!.resources.getString(R.string.category_garden)
            , "file:///android_asset/category/garden.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_light)
            , "file:///android_asset/category/light.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_tools)
            , "file:///android_asset/category/tools.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_building)
            , "file:///android_asset/category/building.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_decor)
            , "file:///android_asset/category/decor.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_colors)
            , "file:///android_asset/category/colors.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_covering)
            , "file:///android_asset/category/covering.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_electrical)
            , "file:///android_asset/category/electrical.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_kitchen)
            , "file:///android_asset/category/kitchen.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_mosaic)
            , "file:///android_asset/category/mosaic.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_nail)
            , "file:///android_asset/category/nail.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_plumbing)
            , "file:///android_asset/category/plumbing.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_storage)
            , "file:///android_asset/category/storage.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_water)
            , "file:///android_asset/category/water.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_windows)
            , "file:///android_asset/category/window.png"))
        add(CategoryItem(appContext!!.resources.getString(R.string.category_woods)
            , "file:///android_asset/category/wood.png"))
    }
}
