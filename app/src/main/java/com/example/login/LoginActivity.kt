package com.example.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Name = findViewById<EditText>(R.id.editTextName)
        val Password = findViewById<EditText>(R.id.Password)

        val submitButton= findViewById<Button>(R.id.buttonSubmit)
        val dispMessage = findViewById<TextView>(R.id.textView3)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECKBOX",false)

        if(isRemembered){
            val masuk = Intent(this@LoginActivity, HalamanHomeActivity::class.java)
            //masuk.putExtra(HalamanHomeActivity.EXTRA_TEXT, user)
            startActivity(masuk)
            finish()
        }


        submitButton.setOnClickListener {
            val user = Name.text.toString()
            val pass = Password.text.toString()
            val check = findViewById<CheckBox>(R.id.checkBox)
            val checked: Boolean = check.isChecked


            if(user.equals("sangga") && pass.equals("123") ) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("NAME",user)
                editor.putString("PASS", pass)
                editor.putBoolean("CHECKBOX", checked)
                editor.apply()

                Toast.makeText(this,"information saved",Toast.LENGTH_LONG).show()

                val masuk = Intent(this@LoginActivity, HalamanHomeActivity::class.java)
                startActivity(masuk)
                finish()
            }else {

                    dispMessage.setText("USER ATAU PASSWORD SALAH checked")

            }
        }
    }


}