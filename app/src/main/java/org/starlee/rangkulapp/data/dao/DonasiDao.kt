//package org.starlee.rangkulapp.data.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//import org.starlee.rangkulapp.data.entity.Donasi
//
//@Dao
//interface DonasiDao {
//    @Insert
//    suspend fun insertDonasi(donasi: Donasi): Long
//
//    @Query("SELECT * FROM donasi WHERE IdDonasi = :IdDonasi")
//    suspend fun getDonasiById(IdDonasi: Int): Donasi?
//
//    @Query("SELECT * FROM donasi WHERE IdPanti = :IdPanti")
//    suspend fun getDonasiByPantiId(IdPanti: Int): List<Donasi>
//
//    @Query("SELECT * FROM donasi WHERE idDonatur = :idDonatur")
//    suspend fun getDonasiByDonaturId(idDonatur: Int): List<Donasi>
//
//    @Update
//    suspend fun updateDonasi(donasi: Donasi)
//
//    @Query("DELETE FROM donasi WHERE IdDonasi = :IdDonasi")
//    suspend fun deleteDonasi(IdDonasi: Int)
//}
