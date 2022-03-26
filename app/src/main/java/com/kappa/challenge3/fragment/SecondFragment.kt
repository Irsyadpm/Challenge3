package com.kappa.challenge3.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kappa.challenge3.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<EditText>(R.id.name_edit_text)
        val buttonScreenTwo = view.findViewById<Button>(R.id.navigate_to_third_fragment_button_a)
        buttonScreenTwo.setOnClickListener {

            val name = nameEditText.text.toString().trim()
            val bundle = Bundle()
            bundle.putString("name", name)

            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
    }
}