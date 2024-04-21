package ru.kanogor.feature_airtickets.presentation.viewgroups

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import ru.kanogor.feature_aviasales.databinding.PopularPlaceButtonBinding

class PopularPlaceButton @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attr, defStyleAttr) {

    private val binding = PopularPlaceButtonBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun setIcon(iconRes: Int) {
        binding.icon.setImageResource(iconRes)
    }

    fun setTitle(title: String) {
        binding.title.text = title
    }

    fun setSubTitle(subTitle: String) {
        binding.subtitle.text = subTitle
    }

}