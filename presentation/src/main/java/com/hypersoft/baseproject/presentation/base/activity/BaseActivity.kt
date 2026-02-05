package com.hypersoft.baseproject.presentation.base.activity

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.hypersoft.baseproject.core.base.activity.ParentActivity
import com.hypersoft.baseproject.core.observers.GeneralObserver
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding>(bindingFactory: (LayoutInflater) -> T) : ParentActivity<T>(bindingFactory) {
    @Inject
    lateinit var generalObserver: GeneralObserver
}