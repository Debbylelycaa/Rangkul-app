import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.starlee.rangkulapp.data.repository.DonaturRepository

class EditProfilViewModel(private val donaturRepository: DonaturRepository) : ViewModel() {
    val id = MutableLiveData("")
    val namaLengkap = MutableLiveData("")
    val noTelepon = MutableLiveData("")
    val alamat = MutableLiveData("")
    val jenisKelamin = MutableLiveData("")
    val tanggalLahir = MutableLiveData("")
    fun initDataFromDatabase() {
        viewModelScope.launch {
            val userId = id.value?.toIntOrNull() ?: 0 // Konversi id dari MutableLiveData ke Int
            val user = donaturRepository.getDonatur(userId) // Panggil fungsi getDonatur dari DonaturRepository
            namaLengkap.value = user.namaLengkap
            noTelepon.value = user.noTelepon
            alamat.value = user.alamat
            jenisKelamin.value = user.jenisKelamin
            tanggalLahir.value = user.tanggalLahir
        }
    }

    fun updateNamaLengkap(nama: String) {
        namaLengkap.value = nama
    }

    fun updateNoTelepon(telepon: String) {
        noTelepon.value = telepon
    }

    fun updateAlamat(alamatBaru: String) {
        alamat.value = alamatBaru
    }

    fun updateJenisKelamin(jenisKelaminBaru: String) {
        jenisKelamin.value = jenisKelaminBaru
    }

    fun updateTanggalLahir(tanggalBaru: String) {
        tanggalLahir.value = tanggalBaru
    }
    fun simpanData(nama: String, telepon: String, alamatBaru: String) {
        namaLengkap.value = nama
        noTelepon.value = telepon
        alamat.value = alamatBaru
        // Tambahkan logika lain yang diperlukan untuk menyimpan data ke penyimpanan atau sumber data lainnya
    }

}
