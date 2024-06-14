//package org.starlee.rangkulapp.util.viewmodelfactory
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import org.starlee.rangkulapp.data.Rangkuldb
//import org.starlee.rangkulapp.data.repository.KomunitasRepository
//import org.starlee.rangkulapp.viewmodel.KomunitasViewModel
//
//class KomunitasViewModelFactory(private val application: Application) :
//    ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(KomunitasViewModel::class.java)) {
//            val komunitasDao = Rangkuldb.getInstance(application).komunitasDao()
//            val repository = KomunitasRepository(komunitasDao)
//            @Suppress("UNCHECKED_CAST")
//            return KomunitasViewModel(application, repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
