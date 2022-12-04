package heenu.moon.moneymountain.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

        Column() {
            TopTitle(viewModel = viewModel, contentPadding)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            CardListContainer(viewModel)
        }

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
fun CardListContainer(viewModel: MainViewModel) {
    viewModel.basicCardList.observeAsState().value?.let { basicCardList ->
        for ((home, number) in basicCardList) {
            BasicCard(titleRes = home.res, subTitle = number.commaAndWithWon())
        }
    }
    viewModel.thisWeeksCard.observeAsState().value?.let { thisWeeksCard ->
        BasicCardWithList(
            titleRes = Home.ThisWeeksExpenditure.res,
            subTitle = thisWeeksCard.totalPrice.commaAndWithWon(),
            list = thisWeeksCard.priceList
        )
    }

}

@Composable
fun BasicCard(titleRes: Int, subTitle: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .clip(RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp)),

        color = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontSize = 18.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = subTitle,
                fontSize = 24.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal
            )
        }
    }
}


@Composable
fun BasicCardWithList(titleRes: Int, subTitle: String, list: List<WeeksData>) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .clip(RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp)),

        color = MaterialTheme.colors.secondary
    ) {
        Column(
            modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontSize = 18.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = subTitle,
                fontSize = 24.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(items = list) { _, item ->
                    Column(modifier = Modifier.weight(1f)) { // todo
                        Text(text = item.date)
                        Text(text = item.price.commaAndWithWon())
                    }
                }
            }
        }
    }

}