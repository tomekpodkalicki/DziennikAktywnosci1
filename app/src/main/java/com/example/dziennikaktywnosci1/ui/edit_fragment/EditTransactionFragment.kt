package com.example.dziennikaktywnosci1.ui.edit_fragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dziennikaktywnosci1.R

class EditTransactionFragment : Fragment() {

    private val viewModel: EditTransactionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_edit_transaction, container, false)
    }
}