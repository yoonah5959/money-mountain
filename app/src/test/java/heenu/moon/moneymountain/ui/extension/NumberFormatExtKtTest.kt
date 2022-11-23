package heenu.moon.moneymountain.ui.extension

import org.junit.Assert
import org.junit.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
internal class NumberFormatExtKtTest {

    @Test
    fun testCommaAndWithWon() {
        val money = 10000000000L
        val (result, time) = measureTimedValue {
            money.commaAndWithWon()
        }
        println("time1 $time")
        Assert.assertEquals(result, "10,000,000,000")
    }


    @Test
    fun testCommaAndWithWon2() {
        val money = 10000000000L
        val (result, time) = measureTimedValue {
            money.commaAndWithWon2()
        }
        println("time2 $time")
        Assert.assertEquals(result, "10,000,000,000")
    }
}