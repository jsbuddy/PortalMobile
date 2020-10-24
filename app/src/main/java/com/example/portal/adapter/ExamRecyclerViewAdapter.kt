package com.example.portal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.portal.R
import com.example.portal.data.model.Paper
import com.example.portal.databinding.ListItemExamBinding

class ExamRecyclerViewAdapter : RecyclerView.Adapter<ExamRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemExamBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paper = differ.currentList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_course_code).text = paper.code
            findViewById<TextView>(R.id.tv_course_title).text = paper.title
            findViewById<TextView>(R.id.tv_date).text = paper.date
            findViewById<TextView>(R.id.tv_time).text = paper.time
            setOnItemClickListener {
                onItemClickListener?.let { it(paper) }
            }
        }
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<Paper>() {
        override fun areItemsTheSame(oldItem: Paper, newItem: Paper): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Paper, newItem: Paper): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((Paper) -> Unit)? = null

    fun setOnItemClickListener(listener: (Paper) -> Unit) {
        onItemClickListener = listener
    }
}