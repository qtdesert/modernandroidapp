package com.example.desert.modernandroidapp.data

import android.os.Handler
import com.example.desert.modernandroidapp.ui.uimodels.Repository

class GitRepoLocalDataSource {

    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3", 430, false))

        Handler().postDelayed({ onRepositoryReadyCallback.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>){
        //TODO: save repositories in DB
    }
}

interface OnRepoLocalReadyCallback {
    fun onLocalDataReady(data: ArrayList<Repository>)
}
