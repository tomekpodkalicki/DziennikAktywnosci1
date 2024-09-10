package com.example.dziennikaktywnosci1.data

import android.content.Context
import com.example.dziennikaktywnosci1.data.models.Transaction
import com.example.dziennikaktywnosci1.data.room.DataBaseInstance

class TransactionRepository(context: Context) {
    private val transactionDao = DataBaseInstance.getInstance(context).transactionDao()

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun updateTransaction(transaction: Transaction){
        transactionDao.updateTransaction(transaction)
    }

    suspend fun deleteTransaction(transaction: List<Transaction>) {
        transactionDao.deleteTransaction(transaction)

    }

    fun getAllTransaction() = transactionDao.getAllTransaction()
    fun getAllIncomes() = transactionDao.getAllIncomes()
    fun getAllOutcomeS() = transactionDao.getAllOutcomeS()
    fun getSumOfAllIncomesByCategory() = transactionDao.getSumOfAllIncomesByCategory()
    fun getSumOfAllOutcomesByCategory() = transactionDao.getSumOfAllOutcomesByCategory()
}