package com.example.leroymerlinjob.fragments

import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leroymerlinjob.R
import com.example.leroymerlinjob.adapters.SearchHintsAdapter
import kotlinx.android.synthetic.main.fragment_catalog_subcategory.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBackStack()

        //focus
        et_search.requestFocus()
        et_search.showSoftKeyboard()

        //Implementation of clear all button
        clearAllImplementation()
        et_search.addTextChangedListener(textChangeListener())

        //Hints
        setupSearchHintsRecyclerView()

    }

    private fun initBackStack() {
        tb_search.setNavigationOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    private fun setupSearchHintsRecyclerView() {
        rv_search_hints.layoutManager = LinearLayoutManager(activity)
        rv_search_hints.adapter = SearchHintsAdapter()
    }


    //show and hide clear all icon
    @SuppressLint("ClickableViewAccessibility")
    private fun clearAllImplementation() {
        et_search.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val rightDrawable = et_search.compoundDrawables[2]
                if (rightDrawable != null) {
                    if (event.rawX >= et_search.right - rightDrawable.bounds.width()) {
                        et_search.text?.clear()
                        return@setOnTouchListener true
                    }
                }
            }
            return@setOnTouchListener false
        }
    }


    private fun textChangeListener(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(et_search.text!!.isNotEmpty()) {
                    showClearAllDrawable()
                } else {
                    hideClearAllDrawable()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
    }



    private fun showClearAllDrawable() {
        et_search.setCompoundDrawablesWithIntrinsicBounds(0,0,
            R.drawable.ic_search_clear_all, 0)
    }

    private fun hideClearAllDrawable() {
        et_search.setCompoundDrawablesWithIntrinsicBounds(0,0,
            0, 0)
    }


    private fun EditText.showSoftKeyboard(){
        (this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }

}