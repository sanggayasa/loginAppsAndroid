package com.example.login.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.login.R
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val setName: TextView = root.findViewById(R.id.textversion)
        //val inputName: EditText = root.findViewById(R.id.editTextName)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
            val time = SimpleDateFormat("DD MM YY hh:mm").format(Date())
            setName.setText("Tgl"+ time)


        })
        return root
    }
}