package ru.kanogor.core_ui.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.kanogor.core_ui.R

fun ImageView.loadImage(item: Any?) {
    Glide.with(this)
        .load(item)
        .error(R.drawable.baseline_broken_image_24)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.baseline_image_24)
        .into(this)
}