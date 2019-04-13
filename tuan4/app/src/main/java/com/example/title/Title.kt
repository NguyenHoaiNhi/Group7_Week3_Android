package com.example.title

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.background.*
import kotlinx.android.synthetic.main.title.*

class Title : AppCompatActivity() {
    private var dfText: String? =  "Dai Hoc k15"
    private var dfColor = "#CC00CC"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.title)
        Edit1.setText(dfText)
        btn1.setOnClickListener{changeColor("#CC00CC", "btn1")}
        btn2.setOnClickListener{changeColor("#339900", "btn2")}
        btn3.setOnClickListener{changeColor("#FDD109", "btn3")}
        btn4.setOnClickListener{changeColor("#0000FF", "btn4")}
        btn5.setOnClickListener{changeColor("#FFCCFF", "btn5")}
        btn6.setOnClickListener{changeColor("#990000", "btn6")}
        Save.setOnClickListener{save()}
        val title_data :Bundle? = intent.extras
        if(title_data != null){
            val title_content = title_data.getString("maincontent")
            Edit1.setText(title_content)
            val color_title = title_data.getString("color_main")
            val set_color_title = Color.parseColor(color_title)
            btn0.setBackgroundColor(set_color_title)
        }
    }
    private fun changeColor(a:String, b: String){
        dfColor = a;
        val mDrawableName: String? = b
        val resID = resources.getIdentifier(mDrawableName, "drawable", packageName)
        btn0.setBackgroundResource(resID)
    }
    private fun save(){
        dfText = Edit1.text.toString()
        intent.putExtra("Color", dfColor)
        intent.putExtra("Text", dfText)
        setResult(Activity.RESULT_OK, intent)
    }
//    private fun handleOnBackScreen() {
//        val url = "https://vnexpress.net/logo.gif"
//        val intent = Intent()
//        intent.putExtra("background", url);
//        intent.putExtra("isDarkMode", false)
//        setResult(Activity.RESULT_OK, intent)
//        finish()
//    }
}