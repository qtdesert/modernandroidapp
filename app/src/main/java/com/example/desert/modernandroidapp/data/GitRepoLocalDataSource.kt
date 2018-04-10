package com.example.desert.modernandroidapp.data

import com.example.desert.modernandroidapp.ui.uimodels.Repository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoLocalDataSource {

    fun getRepositories() : Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First From Local", "Owner 1", 100, false))
        arrayList.add(Repository("Second From Local", "Owner 2", 30, true))
        arrayList.add(Repository("Third From Local", "Owner 3", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>){
        //TODO: save repositories in DB
    }
}
