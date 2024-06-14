//package org.starlee.rangkulapp.data.repository
//
//import androidx.lifecycle.LiveData
//import org.starlee.rangkulapp.data.dao.KomunitasDao
//import org.starlee.rangkulapp.data.entity.Komunitas
//
//class KomunitasRepository(private val komunitasDao: KomunitasDao) {
//
//    fun getAllKomunitas(): LiveData<List<Komunitas>> {
//        return komunitasDao.getAllKomunitas()
//    }
//
//    suspend fun insert(komunitas: Komunitas) {
//        komunitasDao.insertKomunitas(komunitas)
//    }
//}
