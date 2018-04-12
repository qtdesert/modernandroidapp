package com.example.desert.modernandroidapp.ui.screens

import android.arch.lifecycle.ViewModel
import com.example.desert.modernandroidapp.utility.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
