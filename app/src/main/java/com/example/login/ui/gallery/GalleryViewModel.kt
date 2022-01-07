package com.example.login.ui.gallery

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.BuildConfig
import com.example.login.R

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {

        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}