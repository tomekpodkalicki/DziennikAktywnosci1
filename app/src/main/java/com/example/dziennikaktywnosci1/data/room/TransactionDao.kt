package com.example.dziennikaktywnosci1.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dziennikaktywnosci1.data.models.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface

TransactionDao {

    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions_table ORDER BY date DESC")
    fun getAllTransaction(): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions_table WHERE type = 'INCOME' ")
    fun getAllIncomes (): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions_table WHERE type = 'OUTCOME' ")
    fun getAllOutcomeS (): Flow<List<Transaction>>

    @Query("SELECT category, SUM(price) as total FROM transactions_table WHERE type = 'INCOME' GROUP BY category")
    fun getSumOfAllIncomesByCategory() : Flow<List<Transaction>>

    @Query("SELECT category, SUM(price) as total FROM transactions_table WHERE type = 'OUTCOME' GROUP BY category")
    fun getSumOfAllOutcomesByCategory() : Flow<List<Transaction>>

}