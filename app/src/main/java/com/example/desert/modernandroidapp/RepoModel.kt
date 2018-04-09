package com.example.desert.modernandroidapp

import android.os.Handler

class RepoModel {

    fun getRepositories(onRepositoryReadyCallback: onRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100, false))
        arrayList.add(Repository("Second", "Owner 2", 30, true))
        arrayList.add(Repository("Third", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data: String)
}

interface onRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Repository>)
}
