package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンを登録する
        var buttonstrike = findViewById<Button>(R.id.strike)
        var buttonball = findViewById<Button>(R.id.ball)
        var buttonout = findViewById<Button>(R.id.out)
        var buttoninning = findViewById<Button>(R.id.inning)
        var buttontopbuttom = findViewById<Button>(R.id.topbuttom)
        var buttonscp = findViewById<Button>(R.id.scorep)
        var buttonscm = findViewById<Button>(R.id.scorem)
        var buttonreset = findViewById<Button>(R.id.reset)
        var buttonteam = findViewById<Button>(R.id.teamname)

        //textViewを登録する
        var Btv = findViewById<TextView>(R.id.BtextView)
        var Stv = findViewById<TextView>(R.id.StextView)
        var Otv = findViewById<TextView>(R.id.OtextView)
        var Itv = findViewById<TextView>(R.id.ItextView)
        var tbtv = findViewById<TextView>(R.id.tbtextView)
        var sctv = findViewById<TextView>(R.id.sctextView)
        var atTN = findViewById<TextView>(R.id.attackTeamName)

        //カウント用の変数を用意する
        var s: Int = 0      //ストライク変数
        var b: Int = 0      //ボール変数
        var o: Int = 0      //アウト変数
        //イニング用・表/裏の変数を用意する
        var i: Int = 1      //イニング変数
        var tb: Int = 0     //表/裏、変数
        //得点用変数を用意する
        var sc: Int = 0     //得点変数
        //チーム名用の変数を用意する
        var teamName1 = ""    //先攻チーム名
        var teamName2 = ""     //後攻チーム名

        //チーム名を受け取った時の処理
        if(intent.getStringExtra("teamName1") == null && intent.getStringExtra("teamName2") == null){
            teamName1 = ""
            teamName2 = ""
        }else if(intent.getStringExtra("teamName1") != "" && intent.getStringExtra("teamName2") != ""){
            teamName1 = intent.getStringExtra("teamName1").toString()
            teamName2 = intent.getStringExtra("teamName2").toString()
            atTN.setText(teamName1)
        } else {
            teamName1 = ""
            teamName2 = ""
            atTN.setText("チーム名が入力されていません")
        }

        //ボールボタンを押したときの処理
        buttonball.setOnClickListener{
            b += 1
            when(b){
                1 -> Btv.setText("●")
                2 -> Btv.setText("● ●")
                3 -> Btv.setText("● ● ●")
                else -> {
                    b = 0
                    Btv.setText("")
                }
            }
            Btv.setTextColor(Color.GREEN)
        }
        //ストライクボタンを押したときの処理
        buttonstrike.setOnClickListener{
            s += 1
            when(s){
                1 -> Stv.setText("●")
                2 -> Stv.setText("● ●")
                else -> {
                    s = 0
                    Stv.setText("")
                }
            }
            Stv.setTextColor(Color.YELLOW)
        }
        //アウトボタンを押したときの処理
        buttonout.setOnClickListener{
            o += 1
            when(o){
                1 -> Otv.setText("●")
                2 -> Otv.setText("● ●")
                else -> {
                    o = 0
                    Otv.setText("")
                }
            }
            Otv.setTextColor(Color.RED)
        }
        //イニングボタンを押したときの処理
        buttoninning.setOnClickListener{
            i += 1
            if(i < 10) {
                Itv.setText(i.toString() + "回")
            } else{
                i = 1
                Itv.setText(i.toString() + "回")
            }
        }
        //表/裏ボタンを押したときの処理
        buttontopbuttom.setOnClickListener{
            tb += 1
            if(tb % 2 == 1){
                tbtv.setText("裏")
                if(teamName2 != "") {
                    atTN.setText(teamName2)
                }else{
                    atTN.setText("チーム名が入力されていません")
                }
            }
            if(tb % 2 == 0){
                tbtv.setText("表")
                if(teamName1 != "") {
                    atTN.setText(teamName1)
                }else{
                    atTN.setText("チーム名が入力されていません")
                }
            }
        }
        //得点＋ボタンを押したときの処理
        buttonscp.setOnClickListener{
            sc += 1
            sctv.setText(sc.toString())
        }
        //得点ーボタンを押したときの処理
        buttonscm.setOnClickListener{
            sc -= 1
            if(sc < 0){
                sc = 0
                sctv.setText(sc.toString())
            } else {
                sctv.setText(sc.toString())
            }
            sctv.setTextColor(Color.BLACK)
        }
        //リセットボタンを押したときの処理
        buttonreset.setOnClickListener{
            s = 0
            b = 0
            o = 0
            i = 1
            tb = 0
            sc = 0
            Btv.setText("")
            Stv.setText("")
            Otv.setText("")
            Itv.setText(i.toString() + "回")
            tbtv.setText("表")
            atTN.setText("チーム名が入力されていません")
            sctv.setText(sc.toString())
            teamName1 = ""
            teamName2 = ""
        }
        //チーム名入力ボタンを押したときの処理
        buttonteam.setOnClickListener{
            val intent = Intent(applicationContext, TeamNameActivity::class.java)
            startActivity(intent)
        }
    }

}