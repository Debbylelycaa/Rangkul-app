package org.starlee.rangkulapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.starlee.rangkulapp.data.entity.donatur

@Dao
interface DonaturDao {

    @Query("SELECT * FROM donatur")
    suspend fun getAll(): List<donatur>

    @Query("SELECT * FROM donatur WHERE idDonatur IN (:idDonatur)")
    suspend fun loadAllByIds(idDonatur: IntArray): List<donatur>

    @Insert
    suspend fun insertAll(vararg donatur: donatur)

    @Insert
    suspend fun insert(donatur: donatur)

    @Update
    suspend fun update(donatur: donatur)

    @Delete
    suspend fun delete(donatur: donatur)

    @Query("SELECT * FROM donatur WHERE idDonatur = :idDonatur")
    suspend fun getDonaturById(idDonatur: Int): donatur?
}
