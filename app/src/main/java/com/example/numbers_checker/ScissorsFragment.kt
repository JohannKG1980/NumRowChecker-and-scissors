package com.example.numbers_checker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.numbers_checker.databinding.FragmentScissorsBinding


class ScissorsFragment : Fragment() {

    private lateinit var binding: FragmentScissorsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScissorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ibScissors.setOnClickListener {
            binding.ibRock.isEnabled = false
            binding.ibScissors.isEnabled = false
            binding.ibPaper.isEnabled = false
            binding.ibRock.visibility = INVISIBLE
            binding.ibPaper.visibility = INVISIBLE


            gamePlay(1)

        }
        binding.ibRock.setOnClickListener {
            binding.ibScissors.isEnabled = false
            binding.ibPaper.isEnabled = false
            binding.ibRock.isEnabled = false
            binding.ibScissors.visibility = INVISIBLE
            binding.ibPaper.visibility = INVISIBLE
            gamePlay(0)

        }
        binding.ibPaper.setOnClickListener {
            binding.ibRock.isEnabled = false
            binding.ibScissors.isEnabled = false
            binding.ibPaper.isEnabled = false
            binding.ibRock.visibility = INVISIBLE
            binding.ibScissors.visibility = INVISIBLE
            gamePlay(2)

        }

        binding.btnReset.setOnClickListener {
            binding.ibRock.isEnabled = true
            binding.ibPaper.isEnabled = true
            binding.ibScissors.isEnabled = true
            binding.ivCompCoice.setImageResource(0)
            binding.tvWhoWinns.text = ""
            binding.tvComputerChoice.text = ""
            binding.ibRock.visibility = VISIBLE
            binding.ibPaper.visibility = VISIBLE
            binding.ibScissors.visibility = VISIBLE


        }


    }

    fun gamePlay(choice: Int) {
        val map = listOf("Stein", "Schere", "Pappier")
        val img = listOf(R.drawable.rock, R.drawable.scissors, R.drawable.paper)

        val computerChoice = listOf(0, 2, 1).random()

        if (choice == computerChoice) {
            binding.tvWhoWinns.text = "Unentschieden"

        } else if (choice == 0 && computerChoice == 1) {
            binding.tvWhoWinns.text = "Du hast Gewonnen!"
        } else if (choice == 1 && computerChoice == 2) {
            binding.tvWhoWinns.text = "Du hast Gewonnen!"
        } else if (choice == 2 && computerChoice == 0) {
            binding.tvWhoWinns.text = "Du hast Gewonnen!"
        } else {
            binding.tvWhoWinns.text = "Du hast Verloren!"

        }

        binding.ivCompCoice.setImageResource(img[computerChoice])
        binding.tvComputerChoice.text = map[computerChoice]


    }
}