package com.example.numbers_checker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numbers_checker.databinding.FragmentNumbersBinding
import com.google.android.material.internal.ViewUtils


class NumbersFragment : Fragment() {
    private lateinit var binding: FragmentNumbersBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNumbersBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
        val input = binding.teNumbers.text.toString()
            val numbers = stringToSortedNumbers(input)
            val isItInRow = isRow(numbers)
            binding.tvOutput.text = numbers.toString()
            if(isItInRow == null) {
                binding.tvResult.text = "Keine Zahlenfolge eingegeben!"
            } else if (isItInRow == true) {
                binding.tvResult.text = "Zahlenfolge ist in Reihe!"

            } else if(isItInRow == false) {

                binding.tvResult.text = "Keine Zahlenreihenfolge!"



            }

            ViewUtils.hideKeyboard(binding.root)
        }

    }

    fun stringToSortedNumbers(input: String): List<Int> {
        val listUnsorted = mutableListOf<Int>()

        for (char in input) {
            listUnsorted.add(char.toString().toInt())
        }

        val list = listUnsorted.sorted()
        return list
    }

    fun isRow(numbers: List<Int>): Boolean? {
        if (numbers.isEmpty() || numbers.size == 1) {
            return null
        }

        for (i in 0 until numbers.size - 1) {
            if (numbers[i] + 1 != numbers[i + 1]) {
                return false
            }
        }
        return true
    }

}