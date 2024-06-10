import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditProfilViewModel : ViewModel() {
    val namaLengkap = MutableLiveData("")
    val noTelepon = MutableLiveData("")
    val alamat = MutableLiveData("")
    val jenisKelamin = MutableLiveData("")
    val tanggalLahir = MutableLiveData("")
}
