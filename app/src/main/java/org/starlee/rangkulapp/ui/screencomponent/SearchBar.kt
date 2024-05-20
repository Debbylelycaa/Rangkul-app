package org.starlee.rangkulapp.ui.screencomponent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.starlee.rangkulapp.R
import org.starlee.rangkulapp.ui.theme.RangkulAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){
    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    val searchHistory = listOf("Yayasan Panti Asuhan Ahmad Yani", "Panti Asuhan Karya Anak Perdamaian", "Panti Asuhan Muhammadiyah Pesantunan", "Material Design", "GPT-4")

    SearchBar(
        query = query,
        onQueryChange = {query = it} ,
        onSearch = {newQuery ->
            println("Performing search on query: $newQuery")
        },
        active = active,
        onActiveChange = {active = it},
        placeholder = {
            Text(text = stringResource(id = R.string.cari_panti))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
        },
        trailingIcon = {
            Row {
                if (active) {
                    IconButton(
                        onClick = { if (query.isNotEmpty()) query = "" else active = false }
                    ) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                    }
                }
            }
        }
    ) {

        searchHistory.takeLast(3).forEach { item ->
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
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    RangkulAppTheme {
        SearchBar()
    }
}