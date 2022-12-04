package heenu.moon.moneymountain.data.local.dao

import androidx.room.*
import heenu.moon.moneymountain.data.local.model.Budget
import heenu.moon.moneymountain.data.local.model.Expenditure
import java.util.*

@Dao
interface ExpenditureDao {
    @Insert
    fun insert(expenditure: Expenditure)

    @Update
    fun update(expenditure: Expenditure)

    @Delete
    fun delete(expenditure: Expenditure)

    @Query("select * from Expenditure")
    fun getAll():List<Expenditure>

    @Query("select * from Expenditure where date = :targetDate")
    fun findExpenditureOnDate(targetDate: Date): List<Expenditure>

    @Query("select * from Expenditure where date >= :startTimeStamp and date<=:endTimeStamp")
    fun findExpenditureScope(startTimeStamp: Long, endTimeStamp: Long): List<Expenditure>


    @Query("select sum(price) from Expenditure where date >= :startDate and date<=:endDate")
    fun sumExpenditureScope(startDate: Date, endDate: Date): Long

}