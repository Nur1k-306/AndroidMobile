package ru.itis.course2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView

class Screen2_Fragment : Fragment(R.layout.fragment_screen2) {

    private lateinit var textView: TextView
    private lateinit var buttonToScreen3: Button
    private lateinit var buttonBack: Button

    companion object {
        private const val ARG_TEXT = "arg_text"

        fun newInstance(text: String): Screen2_Fragment {
            val fragment = Screen2_Fragment()
            val args = Bundle().apply {
                putString(ARG_TEXT, text)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.textViewDisplay2)
        buttonToScreen3 = view.findViewById(R.id.buttonToScreen3)
        buttonBack = view.findViewById(R.id.buttonBackScreen1)


        val inputText = arguments?.getString(ARG_TEXT)
        textView.text = inputText?.takeIf { it.isNotEmpty() } ?: "Стандартный текст"

        buttonToScreen3.setOnClickListener {
            val textForScreen3 = textView.text.toString()
            val screen3Fragment = Screen3_Fragment.newInstance(textForScreen3)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, screen3Fragment)
                .addToBackStack(null)
                .commit()
        }

        buttonBack.setOnClickListener {
            val screen1Fragment = Screen1_Fragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, screen1Fragment)
                .commit()
        }

    }
}






