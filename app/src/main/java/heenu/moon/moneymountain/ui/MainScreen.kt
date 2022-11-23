package heenu.moon.moneymountain.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import heenu.moon.moneymountain.R
import heenu.moon.moneymountain.theme.pretendard
import heenu.moon.moneymountain.ui.extension.commaAndWithWon

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) { contentPadding ->
        contentPadding
        TopTitle(viewModel = viewModel, contentPadding)

//        val list = viewModel.contentList
    }
}

@Composable
fun TopTitle(viewModel: MainViewModel, contentPadding: PaddingValues) {

    val savedMoney = viewModel.savedMoney.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.totalSavedMoney),
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = savedMoney.commaAndWithWon(),
            fontSize = 32.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Card(titleRes: Int, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(color = MaterialTheme.colors.secondary)
    ) {
        Text(
            text = stringResource(id = titleRes),
            fontSize = 18.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = content,
            fontSize = 24.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal
        )
    }
}
