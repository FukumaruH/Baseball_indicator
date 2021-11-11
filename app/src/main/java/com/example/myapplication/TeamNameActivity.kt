package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TeamNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_name)

        var topteam = findViewById<EditText>(R.id.topteamName)
        var buttomteam = findViewById<EditText>(R.id.buttomteamName)


        var teamName1: String = ""
        var teamName2: String = ""

        //完了ボタンを押したときの処理
        var buttonfinish = findViewById<Button>(R.id.finish)
        buttonfinish.setOnClickListener{
            if(topteam.text.toString() != "" && buttomteam.text.toString() != ""){
                teamName1 = topteam.text.toString()
                teamName2 = buttomteam.text.toString()
            }
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("teamName1", teamName1)
            intent.putExtra("teamName2", teamName2)
            startActivity(intent)
        }
    }
}