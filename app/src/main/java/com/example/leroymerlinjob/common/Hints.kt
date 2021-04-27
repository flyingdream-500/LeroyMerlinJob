package com.example.leroymerlinjob.common

data class SearchHint(
    val name: String
)

object SearchHintSource {
    fun getSearchHints() = ArrayList<SearchHint>().apply {
        add(SearchHint("Шторы"))
        add(SearchHint("Стеллаж"))
        add(SearchHint("Штукатурки"))
        add(SearchHint("Обои"))
        add(SearchHint("Ковер"))
        add(SearchHint("Люстры"))
        add(SearchHint("Зеркало"))
        add(SearchHint("Ламинат"))
        add(SearchHint("Столы"))
        add(SearchHint("Линолеум"))
    }
}