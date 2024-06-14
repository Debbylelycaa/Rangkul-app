//package org.starlee.rangkulapp.data.entity
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.ForeignKey
//import androidx.room.PrimaryKey
//
//@Entity(
//    tableName = "donasi",
//    foreignKeys = [
//        ForeignKey(entity = Donatur::class, parentColumns = ["idDonatur"], childColumns = ["did"]),
//        ForeignKey(entity = Panti::class, parentColumns = ["idPanti"], childColumns = ["IdPanti"])
//    ]
//)
//data class Donasi (
//    @PrimaryKey(autoGenerate = true) var IdDonasi: Int? = null,
//    @ColumnInfo(name = "nominal") var nominal: Int,
//    @ColumnInfo(name = "Asa") var Asa: String?,
//    @ColumnInfo(name = "BuktiPembayaran") var BuktiPembayaran: ByteArray?,
//    @ColumnInfo(name = "MetodePembayaran") var MetodePembayaran: String = "Transfer Bank",
//    @ColumnInfo(name = "IdPanti") var IdPanti: Int,
//    @ColumnInfo(name = "Identitas") var Identitas: String = "Sahabat Baik",
//    @ColumnInfo(name = "idDonatur") var did: Int?
//)
