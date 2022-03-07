package com.example.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val x  = (1..100).toList()
        val tab: IntArray = intArrayOf(1, 3, 2, 5)
        println(missingNumber(tab))
        //        count(x)

    }

    private fun count(x: List<Int>){
        for (i in x){
            if (i % 3 == 0 && i % 5 == 0)(
                    println("trzypiec")
            )else if (i % 5 == 0){
                println("piec")
            }else if (i % 3 == 0){
                println("trzy")
            }else{
                println(i)
            }
        }
    }

    private fun count2(x: List<Int>) {
        for (i in x){
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0)(
                println("trzypiecsiedem")
            )else if (i % 3 == 0 && i % 5 == 0){
                println("trzypiec")
            }else if (i % 3 == 0 && i % 7 == 0){
                println("trzysiedem")
            }else if (i % 5 == 0 && i % 7 == 0){
                println("piecsiedem")
            }else if (i % 3 == 0){
                println("trzy")
            }else if (i % 5 == 0){
                println("piec")
            }else if (i % 7 == 0){
                println("siedem")
            }else{
                println(i)
            }
        }
    }

    private fun count3(x: List<Int>) {
        for (i in x){
            if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0 && i % 11 == 0)(
                println("trzypiecsiedemjedenascie")
            )else if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0){
                println("trzypiecsiedem")
            }else if (i % 5 == 0 && i % 7 == 0 && i % 11 == 0){
                println("piecsiedemjedenascie")
            }else if (i % 7 == 0 && i % 11 == 0){
                println("siedemjedenascie")
            }else if (i % 5 == 0 && i % 11 == 0){
                println("piecjedenascie")
            }else if (i % 3 == 0 && i % 11 == 0){
                println("trzyjedenascie")
            }else if (i % 3 == 0 && i % 7 == 0){
                println("trzysiedem")
            }else if (i % 5 == 0 && i % 7 == 0){
                println("piecsiedem")
            }else if (i % 3 == 0 && i % 5 == 0){
                println("trzypiec")
            }else if (i % 3 == 0){
                println("trzy")
            }else if (i % 5 == 0){
                println("piec")
            }else if (i % 7 == 0){
                println("siedem")
            }else if (i % 11 == 0){
                println("jedenascie")
            }else{
                println(i)
            }
        }
    }

    private fun missingNumber(x: IntArray): String {
        val duplicate = mutableListOf<Int>()
        val original = mutableListOf<Int>()
        for (i in x.minOrNull()!!..x.maxOrNull()!!)
            duplicate += i

        for (i in x)
            original += i

        return if (duplicate == original)
            "0"
        else
            (duplicate.minus(original)).toString().replace("[", "").replace("]", "");

    }


}