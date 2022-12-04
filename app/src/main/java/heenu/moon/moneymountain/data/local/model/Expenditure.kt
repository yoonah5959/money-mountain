package heenu.moon.moneymountain.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Expenditure(
    val date: Date,
    val price: Long
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}