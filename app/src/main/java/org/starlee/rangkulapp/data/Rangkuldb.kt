package org.starlee.rangkulapp.data

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import org.starlee.rangkulapp.data.dao.DonasiDao
import org.starlee.rangkulapp.data.dao.DonaturDao
import org.starlee.rangkulapp.data.dao.KomunitasDao
import org.starlee.rangkulapp.data.dao.PantiDao
import org.starlee.rangkulapp.data.dao.TransaksiDao
import org.starlee.rangkulapp.data.entity.donasi
import org.starlee.rangkulapp.data.entity.donatur
import org.starlee.rangkulapp.data.entity.komunitas
import org.starlee.rangkulapp.data.entity.panti
import org.starlee.rangkulapp.data.entity.transaksi
import java.util.Date

@Database(entities = [donatur::class, komunitas::class, transaksi::class, donasi::class, panti::class], version = 1)
@TypeConverters(Converters::class)
abstract class Rangkuldb : RoomDatabase() {
    abstract fun donaturDao(): DonaturDao
    abstract fun komunitasDao(): KomunitasDao
    abstract fun transaksiDao(): TransaksiDao
    abstract fun donasiDao(): DonasiDao
    abstract fun pantiDao(): PantiDao

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

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
