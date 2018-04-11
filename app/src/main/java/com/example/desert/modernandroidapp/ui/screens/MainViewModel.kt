package com.example.desert.modernandroidapp.ui.screens

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.desert.modernandroidapp.androidmanagers.NetManager
import com.example.desert.modernandroidapp.data.GitRepoRepository
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import com.example.desert.modernandroidapp.utility.extensions.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
                .getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<ArrayList<Repository>>() {
                    override fun onError(e: Throwable) {
                        // If some error happens in our data layer our app will not crash, we will get error here
                    }

                    override fun onNext(data: ArrayList<Repository>) {
                        repositories.value = data
                    }

                    override fun onComplete() {
                        isLoading.set(false)
                    }
                })
    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
