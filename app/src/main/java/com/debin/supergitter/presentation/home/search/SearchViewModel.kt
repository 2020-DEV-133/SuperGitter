package com.debin.supergitter.presentation.home.search

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.debin.supergitter.framework.Interactors
import com.debin.supergitter.framework.SuperGitterViewModel
import com.debin.supergitter.framework.db.UserEntity
import com.debin.supergitter.framework.utils.StateResponse
import com.debin.supergitter.gitrepo.domain.User
import com.debin.supergitter.presentation.home.search.SearchFragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Entity


class SearchViewModel(application: Application, interactors: Interactors) :
     SuperGitterViewModel(application, interactors){
     private val uiScope = CoroutineScope(Dispatchers.IO)
     private val searchUserResult : MutableLiveData<User> = MutableLiveData()
     private lateinit var user : User
     var searchUser = MutableLiveData<String>()
     lateinit var userName: String
     private var _searchState = MutableLiveData<SearchState>()
     val searchState : LiveData<SearchState>
      get() = _searchState



    fun onSearchButtonClicked() {
        userName = searchUser.value.orEmpty().trim()
        uiScope.launch {
            _searchState.value = SearchState.Loading(true)
            searchUserResult.postValue(interactors.searchUser(userName))
        }
        searchUserResult.observeForever {
            _searchState.value = SearchState.Loading(false)
            if(it is User) {
                _searchState.value = SearchState.Success(it)
                user = User(it.avatar_url,  it.id,
                               it.name, it.public_repos)
            } else {
                _searchState.value = SearchState.Error(it.toString())
            }
        }
    }

    fun onAddUserClick() {
        uiScope.launch {
            interactors.addUser(user)
        }

    }
}