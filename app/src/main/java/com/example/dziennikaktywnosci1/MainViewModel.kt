package com.example.dziennikaktywnosci1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dziennikaktywnosci1.data.TransactionRepository
import com.example.dziennikaktywnosci1.data.models.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app : Application): AndroidViewModel(app) {

    private val repos = TransactionRepository(app.applicationContext)

    fun insertTransaction(transaction: Transaction) =
        CoroutineScope(Dispatchers.IO).launch{
            repos.insertTransaction(transaction) }

    fun updateTransaction(transaction: Transaction) =
        CoroutineScope(Dispatchers.IO).launch{
            repos.updateTransaction(transaction) }

    fun deleteTransaction(transactions: List<Transaction>) =
        CoroutineScope(Dispatchers.IO).launch{
            repos.deleteTransaction(transactions) }

    fun getAllTransaction() = repos.getAllTransaction().asLiveData(viewModelScope.coroutineContext)
    fun getAllIncomes() = repos.getAllIncomes().asLiveData(viewModelScope.coroutineContext)
    fun getAllOutcomeS() = repos.getAllOutcomeS().asLiveData(viewModelScope.coroutineContext)
    fun getSumOfAllIncomesByCategory() = repos.getSumOfAllIncomesByCategory().asLiveData(viewModelScope.coroutineContext)
    fun getSumOfAllOutcomesByCategory() = repos.getSumOfAllOutcomesByCategory().asLiveData(viewModelScope.coroutineContext)
}