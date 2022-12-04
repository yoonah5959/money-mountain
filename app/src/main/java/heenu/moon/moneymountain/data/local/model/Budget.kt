package heenu.moon.moneymountain.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Budget(
    val data: String,
    val price: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}