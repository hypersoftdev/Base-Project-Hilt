package com.hypersoft.baseproject.presentation.language.ui

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.hypersoft.baseproject.core.extensions.collectWhenCreated
import com.hypersoft.baseproject.core.extensions.collectWhenStarted
import com.hypersoft.baseproject.core.extensions.navigateTo
import com.hypersoft.baseproject.core.extensions.showToast
import com.hypersoft.baseproject.presentation.R
import com.hypersoft.baseproject.presentation.base.fragment.BaseFragment
import com.hypersoft.baseproject.presentation.databinding.FragmentLanguageBinding
import com.hypersoft.baseproject.presentation.language.adapter.LanguageAdapter
import com.hypersoft.baseproject.presentation.language.effect.LanguageEffect
import com.hypersoft.baseproject.presentation.language.intent.LanguageIntent
import com.hypersoft.baseproject.presentation.language.state.LanguageState
import com.hypersoft.baseproject.presentation.language.viewModel.LanguageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguageFragment : BaseFragment<FragmentLanguageBinding>(FragmentLanguageBinding::inflate) {

    private val viewModel: LanguageViewModel by viewModels()
    private val adapter by lazy { LanguageAdapter() }

    override fun onViewCreated() {
        initRecyclerView()

        binding.mbContinueLanguage.setOnClickListener { viewModel.handleIntent(LanguageIntent.ApplyLanguage) }
    }

    private fun initRecyclerView() {
        binding.rvListLanguage.adapter = adapter
    }

    override fun initObservers() {
        collectWhenStarted(viewModel.state) { renderState(it) }
        collectWhenCreated(viewModel.effect) { handleEffect(it) }
    }

    private fun renderState(state: LanguageState) {
        binding.cpiLoadingLanguage.isVisible = state.isLoading
        adapter.submitList(state.languages)
    }

    private fun handleEffect(effect: LanguageEffect) {
        when (effect) {
            is LanguageEffect.NavigateToDashboard -> navigateTo(R.id.languageFragment, R.id.action_languageFragment_to_dashboardFragment)
            is LanguageEffect.ShowError -> context?.showToast(effect.message)
        }
    }
}