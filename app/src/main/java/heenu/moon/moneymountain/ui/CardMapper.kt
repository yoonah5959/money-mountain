package heenu.moon.moneymountain.ui

import heenu.moon.moneymountain.ui.extension.BasicCardWithList


object CardMapper {
    fun toBasicCardList(userData: UserData): MutableList<Pair<Home, Long>> {
        val list = mutableListOf<Pair<Home, Long>>()
        if (userData.noExpenditureDay > 1) {
            list.add(Pair(Home.NoExpenditureDay, userData.noExpenditureDay))
        }
        list.add(Pair(Home.RemainingLivingExpenses, userData.remainingLivingExpenses))
        list.add(Pair(Home.TodayExpenditure, userData.todayExpenditure))
        return list
    }

    fun toThisWeeksCard(userData: UserData): BasicCardWithList {
        return BasicCardWithList(
            home = Home.ThisWeeksExpenditure,
            content = userData.thisWeeksExpenditure,
            list = userData.thisWeeksExpenditureList
        )
    }
}

