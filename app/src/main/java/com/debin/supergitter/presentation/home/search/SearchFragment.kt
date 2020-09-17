package com.debin.supergitter.presentation.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.debin.supergitter.R
import com.debin.supergitter.gitrepo.domain.User

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return return inflater.inflate(R.layout.fragment_search, container, false)
    }

    sealed class SearchState {
        data class Loading(var loading: Boolean) : SearchState()
        data class Success(var userResponse: User) : SearchState()
        data class Error(var errorMsg: String) : SearchState()
    }
}