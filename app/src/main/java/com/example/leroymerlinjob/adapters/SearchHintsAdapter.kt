package com.example.leroymerlinjob.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.common.SearchHint
import com.example.leroymerlinjob.common.SearchHintSource
import kotlinx.android.synthetic.main.item_search_hint.view.*

class SearchHintsAdapter : RecyclerView.Adapter<SearchHintsAdapter.SearchHintViewHolder>() {
    private var listItems: ArrayList<SearchHint> = SearchHintSource.getSearchHints()


    class SearchHintViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: SearchHint) {
            itemView.tv_search_hint.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHintViewHolder {
        return SearchHintViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search_hint, parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: SearchHintViewHolder, position: Int) {
        holder.bind(listItems.get(position))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}