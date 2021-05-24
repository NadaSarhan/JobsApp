package com.nada.jobsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nada.jobsapp.R
import com.nada.jobsapp.data.model.Job
import com.nada.jobsapp.ui.main.viewmodel.JobViewModel

class JobListAdapter : ListAdapter<Job, JobListAdapter.JobViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        return JobViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.company)
    }

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val jobItemView: TextView = itemView.findViewById(R.id.textViewCompanyName)

        fun bind(text: String?) {
            jobItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): JobViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.job_items, parent, false)
                return JobViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem.company == newItem.company
        }
    }
}