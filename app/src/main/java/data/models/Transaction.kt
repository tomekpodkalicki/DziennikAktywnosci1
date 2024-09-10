package data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions_table")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    val date: Long,
    val price: Int,
    val description: String,
    val type: TransactionType,
    val category: TransactionCategory
)
