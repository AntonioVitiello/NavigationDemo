package com.ant.vit.myapp.ui.amount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ant.vit.myapp.MyApplication
import com.ant.vit.myapp.R

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MoneyAmountModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = MyApplication.staticApplicationContext.getString(R.string.amount_title)
    }
    val text: LiveData<String> = _text
}