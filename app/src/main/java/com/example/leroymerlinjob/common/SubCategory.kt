package com.example.leroymerlinjob.common

data class SubCategory(
    val name: String,
    var dropped: Boolean = false
    )

object SubCategorySource {
    fun getSubCategories() = ArrayList<SubCategory>().apply {
        add(SubCategory("Семена"))
        add(SubCategory("Выращивание рассады"))
        add(SubCategory("Саженцы и рассада"))
        add(SubCategory("Уход за растениями"))
        add(SubCategory("Садовый инвентарь"))
        add(SubCategory("Садовая техника"))
        add(SubCategory("Запчасти и аксессуары для садовой техники"))
        add(SubCategory("Насосы для дома и дачи"))
        add(SubCategory("Обустройство сада и огорода"))
        add(SubCategory("Заборы"))
        add(SubCategory("Защита при работе в саду и огороде"))
        add(SubCategory("Садовая мебель"))
        add(SubCategory("Товары для отдыха на природе"))
        add(SubCategory("Товары для полива"))
        add(SubCategory("Садовый декор"))
        add(SubCategory("Комнатные растения и цветы"))
        add(SubCategory("Средства защиты от насекомых и грызунов"))
        add(SubCategory("Товары для животных"))
        add(SubCategory("Товары для уборки снега"))
        add(SubCategory("Товары для консервирования и виноделия"))
        add(SubCategory("Комплектующие для садовой мебели и бассейнов"))
    }
}