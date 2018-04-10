package com.example.desert.modernandroidapp.data

import com.example.desert.modernandroidapp.androidmanagers.NetManager
import com.example.desert.modernandroidapp.ui.uimodels.Repository
import io.reactivex.Observable

class GitRepoRepository(val netManager: NetManager) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories() : Observable<ArrayList<Repository>> {
        netManager.isConnectedToInternet?.let {
            if (it) {
//                localDataSource.saveRepositories(data) //TODO
                return remoteDataSource.getRepositories()
            }
        }
        return localDataSource.getRepositories()
    }
}
