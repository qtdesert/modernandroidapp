package com.example.desert.modernandroidapp.data

import com.example.desert.modernandroidapp.androidmanagers.NetManager
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import io.reactivex.Observable
import javax.inject.Inject

class GitRepoRepository @Inject constructor(val netManager: NetManager) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories() : Observable<ArrayList<Repository>> {
        netManager.isConnectedToInternet?.let {
            if (it) {
//                return remoteDataSource.getRepositories().flatMap {
//                    return@flatMap localDataSource.saveRepositories(it)
//                            .toSingleDefault(it)
//                            .toObservable()
//                }
            }
        }
        return localDataSource.getRepositories()
    }
}
