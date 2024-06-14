//package org.starlee.rangkulapp.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//import org.starlee.rangkulapp.data.entity.Komunitas
//import org.starlee.rangkulapp.data.repository.KomunitasRepository
//
//class KomunitasViewModel(application: Application, private val repository: KomunitasRepository) : AndroidViewModel(application) {
//
//    val allKomunitas: LiveData<List<Komunitas>> = repository.getAllKomunitas()
//
//    fun insertKomunitas(komunitas: Komunitas) {
//        viewModelScope.launch {
//            repository.insert(komunitas)
//        }
//    }
//}
