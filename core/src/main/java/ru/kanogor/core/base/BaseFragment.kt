package ru.kanogor.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    protected abstract fun initBinding(inflater: LayoutInflater): B?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding(inflater)
        return binding.root
    }

    protected fun <I : Any?> flowObserver(flow: Flow<I>?, action: suspend (it: I) -> Unit) =
        viewLifecycleOwner.lifecycleScope.launch {
            flow?.collect {
                action(it)
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}