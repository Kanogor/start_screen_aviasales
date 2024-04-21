package ru.kanogor.core_ui.view_pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kanogor.core_ui.databinding.ViewPagerItemBinding

class ViewPagerAdapter(
    private val imageUrls: List<String>,
) : RecyclerView.Adapter<ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        return ViewPagerHolder(
            ViewPagerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(imageUrls[position])
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }
}