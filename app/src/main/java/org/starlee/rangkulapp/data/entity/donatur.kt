package org.starlee.rangkulapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class donatur (
    @PrimaryKey(autoGenerate = true) var idDonatur: Int? = null,
    @ColumnInfo(name = "namapengguna") var namaPengguna: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "jeniskelamin") var jenisKelamin: String?,
    @ColumnInfo(name = "telepondonatur") var teleponDonatur: String?,
    @ColumnInfo(name = "namalengkap") var namaLengkap: String?,
    @ColumnInfo(name = "alamat") var alamat: String?,
    @ColumnInfo(name = "emaildonatur") var emailDonatur: String?,
    )