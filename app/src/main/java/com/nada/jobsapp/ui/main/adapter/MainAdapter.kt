package com.nada.jobsapp.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nada.jobsapp.R
import com.nada.jobsapp.data.model.Job
import com.nada.jobsapp.ui.main.FavoriteActivity
import com.nada.jobsapp.ui.main.HomeActivity
import kotlinx.android.synthetic.main.job_items.view.*
import java.security.AccessController.getContext

class MainAdapter(private val jobs: ArrayList<Job>)
    : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(job: Job) {

            itemView.textViewCompanyName.text = job.company

            itemView.textViewJobTitle.text = job.title

            Glide.with(itemView.companyLogo.context)
                .load(job.companyLogo)
                .into(itemView.companyLogo)

//            itemView.imgbtnFav.setOnClickListener(
//                View.OnClickListener {
//                }
//            )

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

    interface OnItemClickListener {
        fun onItemClick(model: Job?)
    }

}