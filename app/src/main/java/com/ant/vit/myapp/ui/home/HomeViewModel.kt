package com.ant.vit.myapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ant.vit.myapp.MyApplication.Companion.staticApplicationContext
import com.ant.vit.myapp.R

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = staticApplicationContext.getString(R.string.home_title)
    }
    val text: LiveData<String> = _text
}