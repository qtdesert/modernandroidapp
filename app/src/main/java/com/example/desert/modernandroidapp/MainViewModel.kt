package com.example.desert.modernandroidapp

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel : ViewModel() {

    var repoModel: RepoModel = RepoModel()

    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    var repositories = ArrayList<Repository>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : onRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
            }
        })
    }
}
