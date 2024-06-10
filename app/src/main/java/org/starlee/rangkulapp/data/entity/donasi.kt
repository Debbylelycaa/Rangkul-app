package org.starlee.rangkulapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "donasi",
    foreignKeys = [
        ForeignKey(entity = donatur::class, parentColumns = ["idDonatur"], childColumns = ["did"]),
        ForeignKey(entity = panti::class, parentColumns = ["idPanti"], childColumns = ["IdPanti"])
    ]
)
data class donasi (
    @PrimaryKey(autoGenerate = true) var IdDonasi: Int? = null,
    @ColumnInfo(name = "nominal") var nominal: Int,
    @ColumnInfo(name = "Asa") var Asa: String?,
    @ColumnInfo(name = "BuktiPembayaran") var BuktiPembayaran: ByteArray?,
    @ColumnInfo(name = "MetodePembayaran") var MetodePembayaran: String = "Transfer Bank",
    @ColumnInfo(name = "IdPanti") var IdPanti: Int,
    @ColumnInfo(name = "Identitas") var Identitas: String = "Sahabat Baik",
    @ColumnInfo(name = "idDonatur") var did: Int?
)
