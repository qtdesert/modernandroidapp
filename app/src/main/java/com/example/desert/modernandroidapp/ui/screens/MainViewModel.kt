package com.example.desert.modernandroidapp.ui.screens

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.desert.modernandroidapp.data.GitRepoRepository
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import com.example.desert.modernandroidapp.data.OnRepositoryReadyCallback

class MainViewModel : ViewModel() {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository()

    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepoRepository.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}
