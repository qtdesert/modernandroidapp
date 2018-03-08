package com.example.desert.modernandroidapp

import android.databinding.BaseObservable
//import android.databinding.Bindable

class Repository (var repositoryName: String?, var repositoryOwner: String?, var numberOfStars: Int?, var hasIssues: Boolean = false)
//    : BaseObservable() {

//    @get:Bindable
//    var repositoryName : String = ""
//    set(value) {
//        field = value
//        notifyPropertyChanged(BR.repositoryName)
//    }
//}