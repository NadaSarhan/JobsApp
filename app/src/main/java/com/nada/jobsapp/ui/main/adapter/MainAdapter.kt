package com.nada.jobsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nada.jobsapp.R
import com.nada.jobsapp.data.model.Job
import kotlinx.android.synthetic.main.job_items.view.*

class MainAdapter(
    private val jobs: ArrayList<Job>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Job) {
            itemView.textViewCompanyName.text = user.company
            itemView.TextViewJobTitle.text = user.title
            Glide.with(itemView.companyLogo.context)
                .load(user.companyLogo)
                .into(itemView.companyLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.job_items, parent,
                false
            )
        )

    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(jobs[position])

    fun addData(list: List<Job>) {
        jobs.addAll(list)
    }

}