//package org.starlee.rangkulapp.data.dao
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import org.starlee.rangkulapp.data.entity.Komunitas
//
//@Dao
//interface KomunitasDao {
//
//    @Insert
//    suspend fun insertKomunitas(komunitas: Komunitas)
//
//    @Query("SELECT * FROM komunitas_table")
//    fun getAllKomunitas(): LiveData<List<Komunitas>>
//}
