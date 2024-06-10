package org.starlee.rangkulapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.starlee.rangkulapp.data.entity.transaksi

@Dao
interface TransaksiDao {
    @Insert
    suspend fun insertTransaksi(transaksi: transaksi): Long

    @Query("SELECT * FROM transaksi WHERE IdTransaksi = :IdTransaksi")
    suspend fun getTransaksiById(IdTransaksi: Int): transaksi?

    @Query("SELECT * FROM transaksi WHERE IdDonatur = :IdDonatur")
    suspend fun getTransaksiByDonaturId(IdDonatur: Int): List<transaksi>

    @Query("SELECT * FROM transaksi WHERE IdDonasi = :IdDonasi")
    suspend fun getTransaksiByDonasiId(IdDonasi: Int): List<transaksi>

    @Update
    suspend fun updateTransaksi(transaksi: transaksi)

    @Query("DELETE FROM transaksi WHERE IdTransaksi = :IdTransaksi")
    suspend fun deleteTransaksi(IdTransaksi: Int)
}
