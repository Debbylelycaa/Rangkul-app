import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.starlee.rangkulapp.data.DonaturDao

class LoginViewModel(private val donaturDao: DonaturDao) : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    fun validateLogin(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = donaturDao.getDonaturLogin(username, password)
            onResult(user != null)
            _username.value = user?.namaPengguna ?: "Pengguna"
            _email.value = user?.emailDonatur ?: "email@example.com"
        }
    }
}
