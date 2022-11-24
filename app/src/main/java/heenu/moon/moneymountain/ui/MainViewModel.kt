package heenu.moon.moneymountain.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import heenu.moon.moneymountain.base.BaseViewModel
import heenu.moon.moneymountain.data.MainDataSource
import heenu.moon.moneymountain.ui.extension.BasicCardWithList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val mainDataSource: MainDataSource) :
    BaseViewModel() {

    private val _savedMoney = MutableStateFlow<Long>(0)
    val savedMoney: StateFlow<Long>
        get() = _savedMoney

    private val _basicCardList = MutableLiveData<List<Pair<Home, Long>>>(listOf())
    val basicCardList: LiveData<List<Pair<Home, Long>>>
        get() = _basicCardList

    private val _thisWeeksCard = MutableLiveData<BasicCardWithList>()
    val thisWeeksCard: LiveData<BasicCardWithList>
        get() = _thisWeeksCard

    init {
        viewModelScope.launch {
            val userData = mainDataSource.getUserData()
            _savedMoney.value = userData.totalSavedMoney
            _basicCardList.value = CardMapper.toBasicCardList(userData)
            _thisWeeksCard.value = CardMapper.toThisWeeksCard(userData)
        }
    }
}