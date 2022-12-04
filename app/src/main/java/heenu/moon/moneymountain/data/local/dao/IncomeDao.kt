package heenu.moon.moneymountain.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import heenu.moon.moneymountain.data.local.model.Budget

@Dao
interface IncomeDao {
    @Insert
    fun insert(budget: Budget)

    @Insert
    fun update(budget: Budget)

    @Insert
    fun delete(budget: Budget)

    @Query("select * from Budget")
    fun getAll(): List<Budget>

}