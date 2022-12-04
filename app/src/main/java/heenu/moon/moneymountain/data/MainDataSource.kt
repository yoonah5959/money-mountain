package heenu.moon.moneymountain.data

import heenu.moon.moneymountain.ui.UserData
import heenu.moon.moneymountain.ui.WeeksData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainDataSource @Inject constructor(){

    fun getUserData(): UserData {
        val userData = UserData(
            totalSavedMoney = 1000000,
            noExpenditureDay = 1,
            remainingLivingExpenses = 2000000,
            todayExpenditure = 0,
            thisWeeksExpenditure = 100000,
            thisWeeksExpenditureList = listOf(1000, 20000, 4000, 1000, 4000)
        )
        return userData
    }

    fun getWeeksData():List<WeeksData>{
        return listOf(
            WeeksData(date = "7.12.월", price = 0),
            WeeksData(date = "7.13.화", price = 1000),
            WeeksData(date = "7.14.수", price = 100000),
            WeeksData(date = "7.15.목", price = 0),
            WeeksData(date = "7.16.금", price = 434000),
            WeeksData(date = "7.17.토", price = 200000000),
            WeeksData(date = "7.18.잉ㄹ", price = 0)
        )
    }
}