package com.example.dziennikaktywnosci1.ui.transactions_fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dziennikaktywnosci1.MainViewModel
import com.example.dziennikaktywnosci1.R
import com.example.dziennikaktywnosci1.databinding.FragmentTransactionsBinding
import com.example.dziennikaktywnosci1.ui.adapters.TransactionAdapter

class TransactionsFragment : Fragment() {

    private val viewModel by viewModels<TransactionsViewModel>()
    private val mainVm by activityViewModels<MainViewModel>()
    private var _binding : FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mainVm.getAllTransaction().observe(viewLifecycleOwner) { transactions ->
            binding.recyclerView.adapter = TransactionAdapter(
                transactions,
                { transaction, position ->
                    Log.d("Test", "Transaction: ${transaction.toString()}")
                }
            )
        }

    }
}