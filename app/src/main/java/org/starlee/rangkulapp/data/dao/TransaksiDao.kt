//package org.starlee.rangkulapp.data.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//import org.starlee.rangkulapp.data.entity.Transaksi
//
//@Dao
//interface TransaksiDao {
//    @Insert
//    suspend fun insertTransaksi(transaksi: Transaksi): Long
//
//    @Query("SELECT * FROM transaksi WHERE IdTransaksi = :IdTransaksi")
//    suspend fun getTransaksiById(IdTransaksi: Int): Transaksi?
//
//    @Query("SELECT * FROM transaksi WHERE IdDonatur = :IdDonatur")
//    suspend fun getTransaksiByDonaturId(IdDonatur: Int): List<Transaksi>
//
//    @Query("SELECT * FROM transaksi WHERE IdDonasi = :IdDonasi")
//    suspend fun getTransaksiByDonasiId(IdDonasi: Int): List<Transaksi>
//
//    @Update
//    suspend fun updateTransaksi(transaksi: Transaksi)
//
//    @Query("DELETE FROM transaksi WHERE IdTransaksi = :IdTransaksi")
//    suspend fun deleteTransaksi(IdTransaksi: Int)
//}
