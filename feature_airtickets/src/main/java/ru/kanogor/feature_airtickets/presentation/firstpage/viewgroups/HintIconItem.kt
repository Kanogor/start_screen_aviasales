package ru.kanogor.feature_airtickets.presentation.firstpage.viewgroups

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.kanogor.feature_aviasales.databinding.HintIconItemBinding

class HintIconItem @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attr, defStyleAttr) {

    private val binding = HintIconItemBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun setIcon(iconRes: Int) {
        binding.icon.setImageResource(iconRes)
    }

    fun setSubTitle(subTitle: String) {
        binding.subtitle.text = subTitle
    }

    fun onClick(onClick: () -> Unit) {
        binding.fullItem.setOnClickListener {
            onClick.invoke()
        }
    }
}