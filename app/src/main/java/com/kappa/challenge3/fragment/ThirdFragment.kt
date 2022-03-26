package com.kappa.challenge3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kappa.challenge3.Data
import com.kappa.challenge3.R

class ThirdFragment : Fragment() {
    val name = this.arguments
    val nameData = name?.get("name")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = this.arguments
        val nameData = name?.get("name")
        val data = arguments?.getParcelable<Data>("key_data")
        val nameTextView = view?.findViewById<TextView>(R.id.name_text_view)
        val addressTextView = view?.findViewById<TextView>(R.id.address_text_view)
        val jobTextView = view?.findViewById<TextView>(R.id.job_text_view)
        val age = data?.age?.toInt()
        val value: String

        nameTextView?.text = nameData.toString()

            if (age != null) {
                value = if (age % 2 == 0) {
                    "$age umur genap"
                } else {
                    "$age umur ganjil"
                }
                val ageTextView = view?.findViewById<TextView>(R.id.age_text_view)
                ageTextView?.text = value
                nameTextView?.text = data?.name
                addressTextView?.text = data?.address
                jobTextView?.text = data?.job
            }

        val buttonScreenThree = view.findViewById<Button>(R.id.navigate_to_fourth_fragment_button)
        buttonScreenThree.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", nameData as String)

            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle)
        }
    }
}