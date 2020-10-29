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
import java.time.format.DateTimeFormatter

class ExamRecyclerViewAdapter : RecyclerView.Adapter<ExamRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemExamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(paper: Paper) {
            with(binding) {
                tvCourseCode.text = paper.code
                tvCourseTitle.text = paper.title
                tvDate.text = paper.date.format(DateTimeFormatter.ofPattern("d MMM, y"))
                tvTime.text = paper.date.format(DateTimeFormatter.ofPattern("HH:mma"))
                active.visibility = if (paper.active) View.VISIBLE else View.GONE
                pending.visibility = if (!paper.active) View.VISIBLE else View.GONE
                root.setOnClickListener {
                    onItemClickListener?.let { it(paper) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemExamBinding.inflate(inflater, parent, false);
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(differ.currentList[position])

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