package heenu.moon.moneymountain.ui


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

    fun toThisWeeksCard(thisWeeksList: List<WeeksData>): WeeksCardData {
        return WeeksCardData(
            titleType = Home.ThisWeeksExpenditure,
            totalPrice = thisWeeksList.sumOf { it.price },
            priceList = thisWeeksList
        )
    }
}

