package heenu.moon.moneymountain.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import heenu.moon.moneymountain.data.local.MoneyMountainDatabase
import heenu.moon.moneymountain.data.local.converter.DateConverters
import heenu.moon.moneymountain.data.local.dao.ExpenditureDao
import heenu.moon.moneymountain.data.local.model.Expenditure
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


internal class ExpenditureDaoTest {

    private lateinit var expenditureDao: ExpenditureDao
    private lateinit var database: MoneyMountainDatabase

    @Before
    fun createDb() {
        val dateConverters = DateConverters()
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context, MoneyMountainDatabase::class.java
        )
            .addTypeConverter(dateConverters)
            .build()
        expenditureDao = database.expenditureDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }


    /**
     * 날짜 범위 안의 데이터를 잘 가져오는지 테스트한다.
     */
    @Test
    @Throws(Exception::class)
    fun testStartAndEndDateQuery(){

        val startTimeStamp = 1669975200L // 2022-12-2 10:00 00
        val endTimeStamp = 1670148000L // 2022-12-4 10:00 00


        val sample1 = 1669899600L // 2022-12-1 13:00 00
        val sample2 = 1670058000L // 2022-12-3 9:00 00
        val sample3 = 1670158800L //  2022-12-4 13:00 00

        val fm = SimpleDateFormat("yyyy-m-d")

        val expenditure1 = Expenditure(
            date = Date(sample1),
            price = 1000
        )

        val expenditure2 = Expenditure(
            date = Date(sample2),
            price = 2000
        )

        val expenditure3 = Expenditure(
            date = Date(sample3),
            price = 3000
        )

        expenditureDao.insert(expenditure1)
        expenditureDao.insert(expenditure2)
        expenditureDao.insert(expenditure3)

        val result = expenditureDao.findExpenditureScope(startTimeStamp,endTimeStamp)

        Assert.assertEquals(result.size, 1)
        Assert.assertEquals(result.first().price, 2000)

    }
}