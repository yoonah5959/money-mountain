package heenu.moon.moneymountain.ui.extension

import timber.log.Timber
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun Long.commaAndWithWon(): String {
    val dec = DecimalFormat("#,###")
    return dec.format(this)


}

fun Long.commaAndWithWon2(): String {
    return NumberFormat.getInstance(Locale.KOREA).format(this)
}