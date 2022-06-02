package com.ivoronline.compose_db_select

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.room.Room

class MyViewModel(application: Application) {

  //REPOSITORIES
  val personRepository: PersonRepository

  //INITIALIZE DATABASE & REPOSITORIES
  init {

    //INITIALIZE DATABASE
    val myDatabase = Room
      .databaseBuilder(application.applicationContext, MyDatabase::class.java, "product_database")
      .fallbackToDestructiveMigration()
      .build()

    //INITIALIZE REPOSITORIES
    val personDao = myDatabase.personDao()
        personRepository = PersonRepository(personDao)

  }

  //METHODS
  public fun insertPerson(person: Person) {
    personRepository.insertPerson(person)
  }

  public fun deletePerson(name: String) {
    personRepository.deletePerson(name)
  }

  public fun findPersonById(id: Int) {
    personRepository.findPersonById(id)
  }

}
