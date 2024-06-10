package org.starlee.rangkulapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.starlee.rangkulapp.data.dao.DonaturDao
import org.starlee.rangkulapp.data.entity.donatur

class DonaturRepository(private val donaturDao: DonaturDao) {

    suspend fun insert(donatur: donatur) {
        withContext(Dispatchers.IO) {
            donaturDao.insert(donatur)
        }
    }

    suspend fun update(donatur: donatur) {
        withContext(Dispatchers.IO) {
            donaturDao.update(donatur)
        }
    }

    suspend fun delete(donatur: donatur) {
        withContext(Dispatchers.IO) {
            donaturDao.delete(donatur)
        }
    }

    suspend fun getDonaturById(id: Int): donatur? {
        return withContext(Dispatchers.IO) {
            donaturDao.getDonaturById(id)
        }
    }

    suspend fun getAllDonaturs(): List<donatur> {
        return withContext(Dispatchers.IO) {
            donaturDao.getAll()
        }
    }

    suspend fun insertDonatur(id: Int, email: String, namapengguna: String, password: String, jeniskelamin: String, telepondonatur: String, alamat: String, namalengkap: String) {
        donaturDao.insert(donatur(id, email, namapengguna, password, jeniskelamin, telepondonatur, alamat, namalengkap))
    }
}
