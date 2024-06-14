package org.starlee.rangkulapp.data.repository

import org.starlee.rangkulapp.data.DonaturDao
import org.starlee.rangkulapp.data.entity.Donatur

class DonaturRepository(private val donaturDao: DonaturDao) {
    suspend fun insert(donatur: Donatur) {
        donaturDao.insertDonatur(donatur)
    }
    suspend fun getDonatur(id: Int): Donatur {
        return donaturDao.getDonatur(id)!!
    }
}
