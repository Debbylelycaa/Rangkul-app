package org.starlee.rangkulapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "donatur_table")
data class Donatur (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = null,
    @ColumnInfo(name = "namapengguna") var namaPengguna: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "jeniskelamin") var jenisKelamin: String?,
    @ColumnInfo(name = "telepondonatur") var teleponDonatur: String?,
    @ColumnInfo(name = "namalengkap") var namaLengkap: String?,
    @ColumnInfo(name = "alamat") var alamat: String?,
    @ColumnInfo(name = "emaildonatur") var emailDonatur: String?,
    @ColumnInfo(name = "noTelepon") var noTelepon: String?,
    @ColumnInfo(name = "tanggalLahir") var tanggalLahir: String?
)
