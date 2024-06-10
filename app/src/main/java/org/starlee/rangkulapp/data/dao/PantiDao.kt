package org.starlee.rangkulapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.starlee.rangkulapp.data.entity.panti

@Dao
interface PantiDao {
    @Insert
    fun insert(panti: panti)

    @Query("SELECT * FROM Panti WHERE idPanti = :idPanti")
    fun getPantiById(idPanti: Int): panti?
}
