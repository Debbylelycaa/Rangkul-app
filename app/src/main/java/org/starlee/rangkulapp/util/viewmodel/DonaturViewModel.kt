package org.starlee.rangkulapp.util.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.starlee.rangkulapp.data.Rangkuldb
import org.starlee.rangkulapp.data.entity.Donatur
import org.starlee.rangkulapp.data.repository.DonaturRepository

class DonaturViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DonaturRepository

    init {
        val donaturDao = Rangkuldb.getInstance(application).donaturDao()
        repository = DonaturRepository(donaturDao)
    }

    fun insert(donatur: Donatur) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(donatur)
    }
}

