package org.starlee.rangkulapp.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.starlee.rangkulapp.data.entity.Donatur

@Dao
interface DonaturDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonatur(donatur: Donatur)

    @Query("SELECT * FROM donatur_table WHERE namapengguna = :username AND password = :password")
    suspend fun getDonaturLogin(username: String, password: String): Donatur?

    @Query("SELECT * FROM donatur_table WHERE id = :id")
    suspend fun getDonatur(id: Int): Donatur?

}
//    @Query("UPDATE donatur_table SET namaLengkap = :namaLengkap, noTelepon = :noTelepon, alamat = :alamat, jenisKelamin = :jenisKelamin, tanggalLahir = :tanggalLahir WHERE id = :id")
//    suspend fun updateDonatur(namaLengkap: String, noTelepon: String, alamat: String, jenisKelamin: String, tanggalLahir: String, id: Int)
//
//    @Query("DELETE FROM donatur_table WHERE id = :id")
//    suspend fun deleteDonatur(id: Int)
//
//    @Query("SELECT * FROM donatur_table WHERE id = :id")
//    fun getDonaturById(id: Int): Flow<Donatur>
//
//    @Query("SELECT * FROM donatur_table")
//    fun getAllDonatur(): Flow<List<Donatur>>

