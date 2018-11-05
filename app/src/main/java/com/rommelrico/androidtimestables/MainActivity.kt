package com.rommelrico.androidtimestables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    var timesTablesListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the SeekBar and TimesTables ListView.
        val timesTablesSeekBar = findViewById<SeekBar>(R.id.timesTablesSeekBar)
        timesTablesListView = findViewById(R.id.timesTablesListView)

        // Some arbitrary values.
        val max = 20
        val startingPosition = 10

    }
}
