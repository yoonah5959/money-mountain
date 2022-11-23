package heenu.moon.moneymountain.ui

/**
 * splash에서 무지출데이를 계산해서 디비로 저장을 하고 main에서 유저데이터를 읽어오는 형식으로 한다.
 */
data class UserData(
    val totalSavedMoney: Long,
    val noExpenditureDay: Long,
    val remainingLivingExpenses: Long,
    val todayExpenditure: Long,
    val thisWeeksExpenditure: Long,
    val thisWeeksExpenditureList: List<Long>,
)