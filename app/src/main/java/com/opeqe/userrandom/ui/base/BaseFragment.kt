package com.opeqe.userrandom.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
open class HiltFragment:Fragment()
open class BaseFragment<VB:ViewBinding>(private val inflate:InflateFragment<VB>) : HiltFragment() {
    private val viewModel: BaseViewModel by viewModels()
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=inflate.invoke(inflater,container,false)
        return binding.root
    }
}

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T