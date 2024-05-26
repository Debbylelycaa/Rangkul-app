package org.starlee.rangkulapp.ui.screencomponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){
    val bg = Color(0xFFC0EFFF)
    val linearGradientBrush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF79CCF0), Color(0xFF6CDAFF))
    )
    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    val searchHistory = listOf("Yayasan Panti Asuhan Ahmad Yani", "Panti Asuhan Karya Anak Perdamaian", "Panti Asuhan Muhammadiyah Pesantunan", "Material Design", "GPT-4")
    Card(
        modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.extraSmall ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                SearchBar(
                    query = query,
                    colors = SearchBarDefaults.colors(Color(0xFF79CCF0)),
                    onQueryChange = { query = it },
                    onSearch = { newQuery ->
                        println("Performing search on query: $newQuery")
                    },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = {
                        Text(text = stringResource(id = R.string.cari_panti), color = bg)
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    },
                    trailingIcon = {
                        Row {
                            if (active) {
                                IconButton(
                                    onClick = {
                                        if (query.isNotEmpty()) query = "" else active = false
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "Close"
                                    )
                                }
                            }
                        }
                    }
                ) {

                 //   searchHistory.takeLast(3).forEach { item ->
//            ListItem(
//                modifier = Modifier.clickable { query = item },
//                headline = { Text(text = item) },
//                icon = {
//                    Icon(
//                        painter = painterResource(R.drawable.baseline_history_24),
//                        contentDescription = null
//                    )
//                }
//            )
                    }

                }
//                Spacer(modifier = Modifier.width(8.dp)) // Spacer untuk memberikan jarak antara teks dan ikon selanjutnya
//                IconButton(
//                    onClick = {
//                        // Tindakan yang diambil ketika ikon di klik
//                    }
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_cloud_upload_24),
//                        contentDescription = "Upload"
//                    )
//                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    RangkulAppTheme {
        SearchBar()
    }
}