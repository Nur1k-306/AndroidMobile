package ru.itis.course2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText


class Screen1_Fragment : Fragment(R.layout.fragment_screen1) {

    private lateinit var editTextInput: EditText
    private lateinit var buttonToScreen2: Button
    private lateinit var buttonToScreen3: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextInput = view.findViewById(R.id.editTextInput)
        buttonToScreen2 = view.findViewById(R.id.buttonToScreen2)
        buttonToScreen3 = view.findViewById(R.id.buttonToScreen3)

        val sharedPreferences = requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val savedText = sharedPreferences.getString("inputText", "")
        editTextInput.setText(savedText)

        buttonToScreen2.setOnClickListener {
            saveInputText()
            val inputText = editTextInput.text.toString()
            val screen2Fragment = Screen2_Fragment.newInstance(inputText)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, screen2Fragment)
                .addToBackStack(null)
                .commit()
        }

        buttonToScreen3.setOnClickListener {
            saveInputText()
            val inputText = editTextInput.text.toString()
            val screen3Fragment = Screen3_Fragment.newInstance(inputText)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, screen3Fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun saveInputText() {
        val inputText = editTextInput.text.toString()
        val sharedPreferences = requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("inputText", inputText).apply()
    }
}




