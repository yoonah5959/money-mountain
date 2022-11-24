package heenu.moon.moneymountain.data

import heenu.moon.moneymountain.ui.UserData
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
}