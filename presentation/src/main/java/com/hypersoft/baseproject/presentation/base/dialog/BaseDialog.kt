package com.hypersoft.baseproject.presentation.base.dialog

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.hypersoft.baseproject.core.base.dialog.ParentDialog
import com.hypersoft.baseproject.core.observers.GeneralObserver
import javax.inject.Inject

abstract class BaseDialog<T : ViewBinding>(bindingFactory: (LayoutInflater) -> T) : ParentDialog<T>(bindingFactory) {
    @Inject
    lateinit var generalObserver: GeneralObserver
}