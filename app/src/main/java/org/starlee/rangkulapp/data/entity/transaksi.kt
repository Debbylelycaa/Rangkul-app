package org.starlee.rangkulapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "transaksi",
    foreignKeys = [
        ForeignKey(entity = donatur::class, parentColumns = ["IdDonatur"], childColumns = ["IdDonatur"]),
        ForeignKey(entity = donasi::class, parentColumns = ["IdDonasi"], childColumns = ["IdDonasi"])
    ]
)
data class transaksi (
    @PrimaryKey(autoGenerate = true) var IdTransaksi: Int? = null,
    @ColumnInfo(name = "No_rekening") var noRekening: String?,
    @ColumnInfo(name = "Nama_bank") var namaBank: String?,
    @ColumnInfo(name = "IdDonatur") var idDonatur: Int,
    @ColumnInfo(name = "IdDonasi") var idDonasi: Int,
    @ColumnInfo(name = "TanggalDonasi") var tanggalDonasi: Date? = Date()
)
