package com.example.albertsonskotlinchallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsonsinterview.models.LongForm
import com.example.albertsonskotlinchallenge.R
import com.example.albertsonskotlinchallenge.utils.Util

class AcronymsAdapter(private val context: Context, private val results: List<LongForm>) :
    RecyclerView.Adapter<AcronymsAdapter.AcronymsResultHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymsResultHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.acronym_item_layout, parent, false)
        return AcronymsResultHolder(itemView)
    }

    override fun onBindViewHolder(holder: AcronymsResultHolder, position: Int) {
        val mLongForm = results[position]
        holder.tvAcronym!!.text = Util.capitalizeByWords(mLongForm.longForm)
        holder.tvYear.text = mLongForm.since.toString()
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class AcronymsResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAcronym: TextView? = itemView.findViewById(R.id.acronym_tv)
        var tvYear: TextView = itemView.findViewById(R.id.year_tv)
    }
}