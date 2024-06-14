//package org.starlee.rangkulapp
//
//import android.graphics.Bitmap
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.ui.Modifier
//import androidx.core.graphics.drawable.toBitmap
//import androidx.lifecycle.ViewModelProvider
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import org.starlee.rangkulapp.data.entity.Komunitas
//import org.starlee.rangkulapp.ui.theme.RangkulAppTheme
//import org.starlee.rangkulapp.util.viewmodelfactory.KomunitasViewModelFactory
//import org.starlee.rangkulapp.viewmodel.KomunitasViewModel
//import java.io.ByteArrayOutputStream
//
//class InsertKomunitasActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val komunitasViewModel = ViewModelProvider(
//            this,
//            KomunitasViewModelFactory(application)
//        ).get(KomunitasViewModel::class.java)
//
//        // Menggunakan Coroutine untuk operasi bitmap
//        CoroutineScope(Dispatchers.Main).launch {
//            val byteArray1 = withContext(Dispatchers.IO) {
//                val drawable = resources.getDrawable(R.drawable.hope, theme)
//                val bitmap = drawable.toBitmap()
//                val stream = ByteArrayOutputStream()
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
//                stream.toByteArray()
//            }
//
//            val byteArray2 = withContext(Dispatchers.IO) {
//                val drawable = resources.getDrawable(R.drawable.kitabisa, theme)
//                val bitmap = drawable.toBitmap()
//                val stream = ByteArrayOutputStream()
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
//                stream.toByteArray()
//            }
//
//            // Contoh data komunitas pertama
//            val komunitas1 = Komunitas(
//                linkWebsite = "https://www.hopeindonesia.org/relawan/",
//                namaKomunitas = "HOPE worldwide Indonesia",
//                kuotaRec = 100,
//                masaOprec = "Senin, 1 Januari 2024 - Jumat, 12 Juli 2024",
//                deskripsiKomunitas = "Agen hope adalah mereka yang membawa harapan dan perubahan hidup dengan sukarela tanpa paksaan – agen yang mempunyai visi dan misi untuk merubah dunia mulai dari diri mereka sendiri. Berbicaralah untuk mereka yang tidak dapat menyuarakan dirinya, belalah mereka yang miskin dan membutuhkan. Jadilah agen pengharapan dengan mendidik, memberikan kesehatan dan melayani mereka yang membutuhkan.",
//                hariOprec = "Senin - Jumat",
//                lokasiKomunitas = "Jakarta",
//                fotoKomunitas = byteArray1
//            )
//
//            // Contoh data komunitas kedua
//            val komunitas2 = Komunitas(
//                linkWebsite = "https://www.loket.com/o/voluntrip",
//                namaKomunitas = "Voluntrip By Kitabisa",
//                kuotaRec = 200,
//                masaOprec = "Selasa, 20 Februari 2024 - Kamis, 20 Juni 2024",
//                deskripsiKomunitas = "Voluntrip by Kitabisa hadir sebagai wadah untuk kamu yang ingin mendapatkan pengalaman menjadi relawan dalam berbagai misi kebaikan. Wujudkan niat baikmu dengan ikut menjadi bagian dalam Voluntrip.",
//                hariOprec = "Selasa - Jumat",
//                lokasiKomunitas = "Jakarta Selatan",
//                fotoKomunitas = byteArray2
//            )
//
//            // Insert data komunitas ke database
//            komunitasViewModel.insertKomunitas(komunitas1)
//            komunitasViewModel.insertKomunitas(komunitas2)
//
//            // Menyelesaikan aktivitas setelah insert selesai
//            finish()
//        }
//
//        setContent {
//            RangkulAppTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    // Tampilan untuk InsertKomunitasActivity (bisa berupa form atau tampilan lain)
//                }
//            }
//        }
//    }
//}
