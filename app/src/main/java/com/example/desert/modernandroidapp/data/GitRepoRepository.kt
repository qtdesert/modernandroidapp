package com.example.desert.modernandroidapp.data

import android.os.Handler
import com.example.desert.modernandroidapp.ui.uimodels.Repository

class GitRepoRepository {

    fun getRepositories(onRepositoryReadyCallback: onRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100, false))
        arrayList.add(Repository("Second", "Owner 2", 30, true))
        arrayList.add(Repository("Third", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
    }
}

interface onRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}
