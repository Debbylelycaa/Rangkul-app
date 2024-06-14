package org.starlee.rangkulapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.starlee.rangkulapp.data.entity.Donatur
@Database(entities = [Donatur::class], version = 1)
//@TypeConverters(Converters::class)
abstract class Rangkuldb : RoomDatabase() {
    abstract fun donaturDao(): DonaturDao
//    abstract fun komunitasDao(): KomunitasDao
//    abstract fun transaksiDao(): TransaksiDao
//    abstract fun donasiDao(): DonasiDao
//    abstract fun pantiDao(): PantiDao

    companion object {
        @Volatile
        private var instance: Rangkuldb? = null

        fun getInstance(context: Context): Rangkuldb {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    Rangkuldb::class.java, "Rangkuldb"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                instance = newInstance
                newInstance
            }
        }
    }
}


