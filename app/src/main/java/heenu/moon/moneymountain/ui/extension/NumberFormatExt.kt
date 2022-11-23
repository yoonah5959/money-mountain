package heenu.moon.moneymountain.ui.extension

import java.text.NumberFormat
import java.util.*


fun Long.commaAndWithWon(): String {
    return NumberFormat.getInstance(Locale.KOREA).format(this) + "원"
}
