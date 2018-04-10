package com.example.desert.modernandroidapp.ui.screens

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.desert.modernandroidapp.androidmanagers.NetManager
import com.example.desert.modernandroidapp.data.GitRepoRepository
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepoRepository.getRepositories().subscribe(object: Observer<ArrayList<Repository>> {
            override fun onSubscribe(d: Disposable) {
                //TODO
            }

            override fun onError(e: Throwable) {
                //TODO
            }

            override fun onNext(data: ArrayList<Repository>) {
                repositories.value = data
            }

            override fun onComplete() {
                isLoading.set(false)
            }
        })
    }
}
