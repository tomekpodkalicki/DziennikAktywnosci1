package com.example.dziennikaktywnosci1.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dziennikaktywnosci1.data.models.Transaction

@Database(entities = [Transaction:: class], version = 1, exportSchema = false)
abstract class TransactionDatabase: RoomDatabase() {
abstract fun transactionDao(): TransactionDao
}