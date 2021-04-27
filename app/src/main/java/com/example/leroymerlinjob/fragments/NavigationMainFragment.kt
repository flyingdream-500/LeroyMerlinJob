package com.example.leroymerlinjob.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.adapters.*
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.main_screen_lists.*
import kotlinx.android.synthetic.main.main_screen_toolbar.*


class NavigationMainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appBarScrollingTransparency()
        setupCatalogRecyclerView()
        setupLimitedProductsRecyclerView()
        setupBestPriceProductsRecyclerView()

        initSearch()


    }


    private fun setupCatalogRecyclerView() {
        rv_main_catalog.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL,false)
        val catalogAdapter = ConcatAdapter(
            CatalogAdapter(),
            CatalogItemsAdapter(),
            CatalogAllAdapter()
        )
        rv_main_catalog.adapter = catalogAdapter
    }

    private fun setupBestPriceProductsRecyclerView() {
        rv_main_best_price_products.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL, false)
        rv_main_best_price_products.adapter = BestPriceProductsAdapter()
    }

    private fun setupLimitedProductsRecyclerView() {
        rv_main_limited_products.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL, false)
        rv_main_limited_products.adapter = LimitedProductsAdapter()
    }

    private fun initSearch() {
        button_main_search.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.searchFragment)
        }
        tb_main.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.searchFragment)
        }
    }


    //Хуйня, переделать!!!
    private fun appBarScrollingTransparency() {
        ab_layout_main.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener {
                    appBarLayout, verticalOffset ->

                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    tb_main.isClickable = true
                    button_main_search.isClickable = false
                    iv_main_barcode.isClickable = false
                } else if (verticalOffset == 0) {
                    tb_main.isClickable = false
                    button_main_search.isClickable = true
                    iv_main_barcode.isClickable = true
                }

                val res = ((
                        appBarLayout?.totalScrollRange!! + verticalOffset).toFloat() / appBarLayout.totalScrollRange * 255 + 1).toInt()

                Log.d("AAA", ((appBarLayout?.totalScrollRange + verticalOffset).toFloat() / appBarLayout.totalScrollRange).toString())
                button_main_search.alpha = (appBarLayout?.totalScrollRange + verticalOffset).toFloat() / appBarLayout.totalScrollRange
                iv_main_barcode.alpha = (appBarLayout?.totalScrollRange + verticalOffset).toFloat() / appBarLayout.totalScrollRange
                ab_layout_main.background.alpha = res
            })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NavigationMainFragment()
    }
}