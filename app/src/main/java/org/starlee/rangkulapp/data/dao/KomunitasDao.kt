package org.starlee.rangkulapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.starlee.rangkulapp.data.entity.komunitas

@Dao
interface KomunitasDao {
    @Insert
    fun insert(komunitas: komunitas)

    @Query("SELECT * FROM Komunitas WHERE idKomunitas = :idKomunitas")
    fun getKomunitasById(idKomunitas: Int): komunitas?
}
