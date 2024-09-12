package com.example.dziennikaktywnosci1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dziennikaktywnosci1.data.models.Transaction
import com.example.dziennikaktywnosci1.databinding.TransactionRowBinding

class TransactionsAdapter(private val transactions: List<Transaction>,
                          private val onCLick: (Transaction, Int) -> Unit):
    RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {


    inner class TransactionViewHolder(binding: TransactionRowBinding) :
        RecyclerView.ViewHolder(binding.root) {


        init {
            binding.root.setOnClickListener {
                onCLick(transactions[adapterPosition], adapterPosition)
            }
        }
        val date = binding.dateTv
        val price = binding.priceTv
        val category = binding.categoryTv
        val type = binding.typeTv
        val icon = binding.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            TransactionRowBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
            return transactions.size
    }
}