package com.usfzy.viewmodellivedata.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.usfzy.viewmodellivedata.R
import com.usfzy.viewmodellivedata.viewmodels.TotalsViewModel

class SplitFragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_split_one, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareViewModel()
    }

    private fun prepareViewModel() {
        val totalsViewModel = ViewModelProvider(requireActivity())[TotalsViewModel::class.java]
        totalsViewModel.getTotal().observe(viewLifecycleOwner, Observer {
            updateTotal(it)
        })

        view?.findViewById<Button>(R.id.fragment_split_one_button)?.setOnClickListener {
            totalsViewModel.increment()
        }
    }

    private fun updateTotal(total: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text_view)?.text =
            getString(R.string.total, total)
    }
}