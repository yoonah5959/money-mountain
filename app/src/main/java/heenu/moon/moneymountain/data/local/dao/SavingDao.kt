package heenu.moon.moneymountain.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import heenu.moon.moneymountain.data.local.model.Saving

@Dao
interface SavingDao {
    @Insert
    fun insert(saving: Saving)

    @Insert
    fun update(saving: Saving)

    @Insert
    fun delete(saving: Saving)

    @Query("select * from Saving")
    fun getAll(): List<Saving>

    @Query("select sum(price) from Saving")
    fun getAllSum(): Long

}