package com.kappa.challenge3.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kappa.challenge3.Data
import com.kappa.challenge3.R

class FourthFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonScreenFour = view.findViewById<Button>(R.id.navigate_to_third_fragment_button_b)
        buttonScreenFour.setOnClickListener {
            val name = this.arguments
            val nameData = name?.get("name")
            val ageEditText = view.findViewById<EditText>(R.id.age_edit_text)
            val addressEditText = view.findViewById<EditText>(R.id.address_edit_text)
            val jobEditText = view.findViewById<EditText>(R.id.job_edit_text)
            val thirdFragment = ThirdFragment()


            val bundle = Bundle()

            val data = Data(
                name = nameData.toString(),
                ageEditText?.text.toString().trim(),
                addressEditText?.text.toString().trim(),
                jobEditText?.text.toString().trim()
            )
            bundle.putParcelable("key_data", data)
            thirdFragment.arguments = bundle
            Log.d("LoginActivity", data.toString())


            findNavController().navigate(R.id.action_fourthFragment_to_thirdFragment, bundle)
        }
    }
}
