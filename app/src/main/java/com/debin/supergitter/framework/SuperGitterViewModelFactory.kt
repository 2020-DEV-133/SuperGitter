package com.debin.supergitter.framework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object SuperGitterViewModelFactory : ViewModelProvider.Factory {

     lateinit var application: Application
     lateinit var dependencies : Interactors

    fun inject(application: Application, dependencies : Interactors) {
        SuperGitterViewModelFactory.application = application
        SuperGitterViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(SuperGitterViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Interactors::class.java)
                .newInstance(application, dependencies)
        } else {
            throw IllegalStateException("ViewModel must extend SuperGitterViewModel")
        }
    }

}