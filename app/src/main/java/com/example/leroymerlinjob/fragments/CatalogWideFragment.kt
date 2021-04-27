package com.example.leroymerlinjob.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.adapters.CatalogWideAdapter
import kotlinx.android.synthetic.main.fragment_catalog_wide.*


class CatalogWideFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog_wide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBackStack()

        setupCatalogWideRecyclerView(spanCount = 2)
    }

    private fun initBackStack() {
        tb_catalog_wide.setNavigationOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun setupCatalogWideRecyclerView(spanCount: Int) {
        rv_catalog_wide.layoutManager = GridLayoutManager(
            activity, spanCount, GridLayoutManager.VERTICAL, false)
        rv_catalog_wide.adapter = CatalogWideAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CatalogWideFragment()

    }
}