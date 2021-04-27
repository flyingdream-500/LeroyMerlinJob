package com.example.leroymerlinjob.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.adapters.SubCategoryAdapter
import kotlinx.android.synthetic.main.fragment_catalog_subcategory.*
import kotlinx.android.synthetic.main.fragment_search.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import kotlinx.android.synthetic.main.fragment_catalog_wide.*


class SubCategoriesFragment : Fragment(), SubCategoryAdapter.SubCategoryScrollListener {

    private lateinit var smoothScroller: SmoothScroller
    private lateinit var linearLayout: LinearLayoutManager

    companion object {
        const val CATEGORY_NAME = "key of category name"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog_subcategory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBackStack()

        setupToolbarTitle()

        setupSubCategoryRecyclerView()
    }

    private fun setupToolbarTitle() {
        val categoryName = arguments?.getString(CATEGORY_NAME)
        tb_subcategory.title = categoryName
    }

    private fun initBackStack() {
        tb_subcategory.setNavigationOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun setupSubCategoryRecyclerView() {
        smoothScroller = getSmoothScroller()

        linearLayout = LinearLayoutManager(activity)

        rv_subcategory.layoutManager = linearLayout
        rv_subcategory.adapter = SubCategoryAdapter(this)
    }


    override fun scrollToPosition(position: Int) {
        smoothScroller.targetPosition = position
        linearLayout.startSmoothScroll(smoothScroller)
    }

    private fun getSmoothScroller(): LinearSmoothScroller {
        return object : LinearSmoothScroller(context) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
    }



}