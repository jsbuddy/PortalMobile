package com.example.portal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portal.R
import com.example.portal.data.model.OnboardingSlide
import kotlinx.android.synthetic.main.item_onboarding_slide.view.*

class OnboardingViewPagerAdapter(private val slides: List<OnboardingSlide>) :
    RecyclerView.Adapter<OnboardingViewPagerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding_slide, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slide = slides[position]
        holder.itemView.text.text = slide.text
        holder.itemView.image.setImageResource(slide.image)
    }

    override fun getItemCount() = slides.size
}