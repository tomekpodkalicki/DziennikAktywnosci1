package data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import data.models.Transaction

@Database(entities = [Transaction:: class], version = 1, exportSchema = false)
abstract class TransactionDatabase: RoomDatabase() {
abstract fun transactionDao(): TransactionDao
}