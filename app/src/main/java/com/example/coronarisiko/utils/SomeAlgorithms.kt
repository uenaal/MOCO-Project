package com.example.coronarisiko.utils

import android.content.Context
import com.example.coronarisiko.R
import com.example.coronarisiko.model.csvDataModel
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class SomeAlgorithms {

        private var TAG = "Algorithms"

        fun stringChanger(jsonObjectString: String): String {
            // Algorithm from https://stackoverflow.com/questions/57865562/java-replaceall-with-except-first-and-last-occurrence
            val sb = StringBuilder(jsonObjectString)
            val first: Int = jsonObjectString.indexOf("\"")
            val last: Int = jsonObjectString.lastIndexOf("\"")
            if (first != last) {
                var i = first + 1
                while (i < last) {
                    if (sb[i] == '\'') {
                        sb.insert(i, '\'')
                        i++
                    }
                    i++
                }
            }
            return sb.toString()
        }

        fun readCSV (context : Context) : MutableList<csvDataModel> {
            val csvList = mutableListOf<csvDataModel>()
            val inputStream = context.resources.openRawResource(R.raw.zuordnung_plz_ort_landkreis)

            csvReader().open(inputStream){
                readAllAsSequence().forEach { row ->
                    val oneRow = csvDataModel()
                    oneRow.csvId = row[0]
                    oneRow.csvAGS = row[1]
                    oneRow.csvLocality = row[2]
                    oneRow.csvPLZ = row[3]
                    oneRow.csvDistrict = row[4]
                    oneRow.csvState = row[5]

                    // Log.d(TAG, "readCSV: ${oneRow.csvPLZ}")
                    
                    csvList.add(oneRow)
                }
            }
            return csvList
        }
}
