package com.example.desert.modernandroidapp.ui.screens

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.desert.modernandroidapp.androidmanagers.NetManager
import com.example.desert.modernandroidapp.data.GitRepoRepository
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import com.example.desert.modernandroidapp.data.OnRepositoryReadyCallback

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)

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
