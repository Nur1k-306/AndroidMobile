package ru.itis.course2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView

class Screen3_Fragment : Fragment(R.layout.fragment_screen3) {

    private lateinit var textView: TextView
    private lateinit var buttonBack: Button
    private lateinit var screenTitle: TextView

    companion object {
        private const val ARG_TEXT = "arg_text"

        fun newInstance(text: String): Screen3_Fragment {
            val fragment = Screen3_Fragment()
            val args = Bundle().apply {
                putString(ARG_TEXT, text)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textViewDisplay3)
        buttonBack = view.findViewById(R.id.buttonBackScreen2)

        val inputText = arguments?.getString(ARG_TEXT).takeIf { !it.isNullOrEmpty() } ?: "Стандартный текст"
        textView.text = inputText

        buttonBack.setOnClickListener {
            val screen2Fragment = Screen2_Fragment.newInstance(inputText)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, screen2Fragment)
                .commit()
        }
    }
}







