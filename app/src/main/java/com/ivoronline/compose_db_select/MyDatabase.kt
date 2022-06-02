package com.ivoronline.compose_db_select

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)  //Entities
abstract class MyDatabase() : RoomDatabase() {
  abstract fun personDao(): PersonDao               //DAOs
}
