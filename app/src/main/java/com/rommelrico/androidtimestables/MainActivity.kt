package com.rommelrico.androidtimestables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    var timesTablesListView: ListView? = null

    fun generateTimesTable(timesTableNumber: Int) {
        val timesTableContent = arrayListOf<String>()

        for (j in 1..100) {
            timesTableContent.add(Integer.toString(j * timesTableNumber))
        }

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, timesTableContent)
        timesTablesListView.adapter = arrayAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the SeekBar and TimesTables ListView.
        val timesTablesSeekBar = findViewById<SeekBar>(R.id.timesTablesSeekBar)
        timesTablesListView = findViewById(R.id.timesTablesListView)

        // Some arbitrary values.
        val max = 20
        val startingPosition = 10

        // Generate the Times Tables.
        generateTimesTable(startingPosition)

        // Changing the contents based on the values from the SeekBar.
        timesTablesSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {

            /**
             * Notification that the progress level has changed. Clients can use the fromUser parameter
             * to distinguish user-initiated changes from those that occurred programmatically.
             *
             * @param seekBar The SeekBar whose progress has changed
             * @param progress The current progress level. This will be in the range min..max where min
             * and max were set by [ProgressBar.setMin] and
             * [ProgressBar.setMax], respectively. (The default values for
             * min is 0 and max is 100.)
             * @param fromUser True if the progress change was initiated by the user.
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val min = 1
                var timesTableNumber = 0

                if (progress < min) {
                    timesTableNumber = min
                    timesTablesSeekBar.progress = min
                } else {
                    timesTableNumber = progress
                }

                generateTimesTable(timesTableNumber)
            }

            /**
             * Notification that the user has started a touch gesture. Clients may want to use this
             * to disable advancing the seekbar.
             * @param seekBar The SeekBar in which the touch gesture began
             */
            override fun onStartTrackingTouch(seekBar: SeekBar?) { }

            /**
             * Notification that the user has finished a touch gesture. Clients may want to use this
             * to re-enable advancing the seekbar.
             * @param seekBar The SeekBar in which the touch gesture began
             */
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }

        })

    }
}
