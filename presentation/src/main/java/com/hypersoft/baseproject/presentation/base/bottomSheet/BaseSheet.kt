package com.hypersoft.baseproject.presentation.base.bottomSheet

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.hypersoft.baseproject.core.base.bottomSheets.ParentSheet
import com.hypersoft.baseproject.core.observers.GeneralObserver
import javax.inject.Inject

abstract class BaseSheet<T : ViewBinding>(bindingFactory: (LayoutInflater) -> T) : ParentSheet<T>(bindingFactory) {
    @Inject
    lateinit var generalObserver: GeneralObserver
}