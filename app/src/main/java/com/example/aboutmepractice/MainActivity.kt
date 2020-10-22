package com.example.aboutmepractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutmepractice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Ed Ekanem")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//
//        findViewById<Button>(R.id.btn_done).setOnClickListener {
//            nickName(it)
//        }

        binding.btnDone.setOnClickListener {
            nickName(it)
        }
    }


    private fun nickName(view: View) {
//        val editText = findViewById<EditText>(R.id.edit_txt)
////        val nickNameText = findViewById<TextView>(R.id.hidden_txt)
////
////        nickNameText.text = editText.text
//////        editText.visibility = View.GONE
//////        view.visibility = View.GONE
//////        nickNameText.visibility = View.VISIBLE


binding.apply {
//    binding.nicknameText.text = binding.nicknameEdit.text

    myName?.nickname = nicknameEdit.text.toString()
    invalidateAll()
    binding.nicknameEdit.visibility = View.GONE
    binding.btnDone.visibility = View.GONE
    binding.nicknameText.visibility = View.VISIBLE
}

        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}