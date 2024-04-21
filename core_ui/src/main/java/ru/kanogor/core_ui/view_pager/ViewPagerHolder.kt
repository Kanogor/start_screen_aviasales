package ru.kanogor.core_ui.view_pager

import androidx.recyclerview.widget.RecyclerView
import ru.kanogor.core_ui.databinding.ViewPagerItemBinding
import ru.kanogor.core_ui.utils.loadImage

class ViewPagerHolder(
    private val binding: ViewPagerItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(imageUrl: String){
        binding.image.loadImage(imageUrl)
    }
}