package com.example.desert.modernandroidapp.data

import com.example.desert.modernandroidapp.ui.uimodels.Repository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class GitRepoRemoteDataSource {

    fun getRepositories() : Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from remote", "Owner 1", 100, false))
        arrayList.add(Repository("Second from remote", "Owner 2", 30, true))
        arrayList.add(Repository("Third from remote", "Owner 3", 430, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }
}
