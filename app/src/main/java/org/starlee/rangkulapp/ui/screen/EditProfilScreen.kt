package org.starlee.rangkulapp.ui.screen

import android.app.DatePickerDialog
import android.content.res.Configuration
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilScreen(navController: NavHostController) {

    val customColor = colorResource(id = R.color.custom_blue)

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(33.dp)
                                .background(Color.White, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.kembali),
                                tint = Color.Black
                            )
                        }
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.ganti_kata_sandi),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(start = 16.dp) )


                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = customColor,
                    titleContentColor = customColor,
                )
            )
        }
    ) { padding ->
        EditProfilContent(Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilContent(modifier: Modifier) {

    val namalengkapState = remember { mutableStateOf("") }
    val noteleponState = remember { mutableStateOf("") }
    val alamatState = remember { mutableStateOf("") }
    val genderOptions = listOf("Pria", "Wanita")
    val selectedGenderState = remember { mutableStateOf(genderOptions[0]) }
    val dateState = remember { mutableStateOf("") }

    val customColor = colorResource(id = R.color.custom_blue)

    // DatePicker
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            dateState.value = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(28.dp),
        color = Color.Transparent
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start // Align items to the start (left)
        ) {
            item {
                Text(
                    text = "Profil Saya",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(34.dp))
                Text(
                    text = "Nama Lengkap",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(
                    value = namalengkapState.value,
                    onValueChange = { newValue ->
                        namalengkapState.value = newValue
                    },
                    label = { Text("Khalilah Atika Akmal") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = customColor,
                        unfocusedBorderColor = customColor,
                        // Setting the label color to grey
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Jenis Kelamin",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                genderOptions.forEach { gender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = selectedGenderState.value == gender,
                            onClick = { selectedGenderState.value = gender },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = customColor,
                                unselectedColor = Color.Gray
                            )
                        )
                        Text(
                            text = gender,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Tanggal Lahir",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(
                    value = dateState.value,
                    onValueChange = { /* do nothing */ },
                    label = { Text("Pilih Tanggal") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { datePickerDialog.show() },
                    readOnly = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = customColor,
                        unfocusedBorderColor = customColor,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { /* on click action */ },
                        modifier = Modifier
                            .width(130.dp)
                            .height(38.dp)
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Simpan",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "No Telepon",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(
                    value = noteleponState.value,
                    onValueChange = { newValue ->
                        noteleponState.value = newValue
                    },
                    label = { Text("08xxxxxxxx") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = customColor,
                        unfocusedBorderColor = customColor,
                        // Setting the label color to grey
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Alamat",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(3.dp))
                OutlinedTextField(
                    value = alamatState.value,
                    onValueChange = { newValue ->
                        alamatState.value = newValue
                    },
                    label = { Text("Jalan......") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = customColor,
                        unfocusedBorderColor = customColor,
                        // Setting the label color to grey
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { /* on click action */ },
                        modifier = Modifier
                            .width(130.dp)
                            .height(38.dp)
                            .align(Alignment.Center), // Center the button horizontally
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Simpan",
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun EditProfilScreenPreview() {
    RangkulAppTheme {
        EditProfilScreen(rememberNavController())
    }
}