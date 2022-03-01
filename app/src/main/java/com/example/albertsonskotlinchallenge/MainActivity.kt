package com.example.albertsonskotlinchallenge

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonsinterview.models.AcronymResponse
import com.example.albertsonsinterview.models.LongForm
import com.example.albertsonskotlinchallenge.adapters.AcronymsAdapter
import com.example.albertsonskotlinchallenge.utils.Util
import com.example.albertsonskotlinchallenge.viewmodels.AcronymsViewModel

class MainActivity : AppCompatActivity() {
    private var viewModel: AcronymsViewModel? = null
    private var acronymsAdapter: AcronymsAdapter? = null
    private var results = mutableListOf<LongForm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(AcronymsViewModel::class.java)
        acronymsAdapter = results.let { AcronymsAdapter(this, it) }
        findViewById<RecyclerView>(R.id.rvAcronymList).adapter = acronymsAdapter
        findViewById<Button>(R.id.search_btn).setOnClickListener { performSearch() }
    }

    private fun performSearch() {
        Util.hideKeyboard(this@MainActivity)
        val keyword = findViewById<EditText>(R.id.et_search).editableText.toString()
        viewModel!!.getAcronymsResponseLiveData(keyword)
            .observe(this, { acronymResponses: List<AcronymResponse>? ->
                if (acronymResponses != null) {
                    if (acronymResponses.isNotEmpty()) {
                        results.clear()
                        acronymResponses[0].longForms?.let { results.addAll(it) }
                        acronymsAdapter?.notifyDataSetChanged()
                    } else {
                        Toast.makeText(this, NO_RECORDS_FOUND, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, ERROR_IN_CALLING_API, Toast.LENGTH_SHORT).show()
                }
            } as (List<AcronymResponse?>?) -> Unit)
    }

    override fun onResume() {
        super.onResume()
        val keyword = findViewById<EditText>(R.id.et_search).editableText.toString()
        if (keyword.isNotEmpty()) {
            performSearch()
        }
    }

    companion object {
        const val NO_RECORDS_FOUND = "No Records Found"
        const val ERROR_IN_CALLING_API = "Error in calling API"
    }

}