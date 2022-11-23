package heenu.moon.moneymountain.ui

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import heenu.moon.moneymountain.base.BaseViewModel
import heenu.moon.moneymountain.data.MainDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel  constructor() :
    BaseViewModel() {

    private val _savedMoney = MutableStateFlow<Long>(0)
    val savedMoney: StateFlow<Long>
        get() = _savedMoney

    init {
        viewModelScope.launch {
//            val userData = mainDataSource.getUserData()

        }

    }

}