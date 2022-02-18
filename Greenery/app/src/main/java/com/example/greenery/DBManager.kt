package com.example.greenery

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(context: Context?,
                name: String?,
                factory: SQLiteDatabase.CursorFactory?,
                version: Int): SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqliteDB: SQLiteDatabase?) {

        // 내 식물 DB
        sqliteDB!!.execSQL("CREATE TABLE my_plant_db (id INTEGER PRIMARY KEY, " +
                                  "species NOT NULL REFERENCES plant_dictionary_db(species) ON UPDATE CASCADE ON DELETE RESTRICT, " +
                                  "nickname TEXT, my_plant_photo_name TEXT, brought_date DATE, last_water_date DATE, " +
                                  "last_nutrition_date DATE, last_separation_date DATE);")

        // 내 식물 일기 DB
        sqliteDB!!.execSQL("CREATE TABLE my_plant_diary_db (id INTEGER PRIMARY KEY, " +
                                "nickname NOT NULL REFERENCES my_plant_db(nickname) ON UPDATE CASCADE ON DELETE SET NULL, " +
                                "species NOT NULL REFERENCES plant_dictionary_db(species) ON UPDATE CASCADE ON DELETE RESTRICT, " +
                                "my_plant_diary_photo_name TEXT, write_date DATE, to_do_water BOOLEAN, to_do_sunshine BOOLEAN, " +
                                "to_do_wind BOOLEAN, to_do_nutrition BOOLEAN, to_do_separation BOOLEAN, to_do_branch BOOLEAN, " +
                                "to_do_spray BOOLEAN, to_do_observe BOOLEAN, memo TEXT);")

        // 내 식물 일정 DB
        sqliteDB!!.execSQL("CREATE TABLE my_plant_schedule_db (id INTEGER PRIMARY KEY, " +
                                "nickname NOT NULL REFERENCES my_plant_db(nickname) ON UPDATE CASCADE ON DELETE SET NULL, " +
                                "species NOT NULL REFERENCES plant_dictionary_db(species) ON UPDATE CASCADE ON DELETE RESTRICT, " +
                                "schedule_date DATE, schedule_water BOOLEAN, schedule_nutrition BOOLEAN, " +
                                "schedule_separation BOOLEAN, complete_schedule_water BOOLEAN, " +
                                "complete_schedule_nutrition BOOLEAN, complete_schedule_separation BOOLEAN);")

        // 식물 사전 DB
        sqliteDB!!.execSQL("CREATE TABLE plant_dictionary_db (species text PRIMARY KEY, explanation TEXT, " +
                                "plant_dictionary_photo_name TEXT, water_period_day INTEGER, separation_period_day INTEGER, " +
                                "water_amount TEXT, sunshine TEXT, temperature TEXT, " +
                                "water_tip TEXT, sunshine_tip TEXT, separation_tip TEXT, plus_tip TEXT);")
    }

    override fun onUpgrade(sqliteDB: SQLiteDatabase?, oldVersion: Int, nweVersion: Int) {
    }
}