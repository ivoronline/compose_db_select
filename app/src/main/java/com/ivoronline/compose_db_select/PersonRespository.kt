package com.ivoronline.compose_db_select

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*

class PersonRepository(private val productDao: PersonDao) {

  //PROPERTIES
  private val coroutineScope = CoroutineScope(Dispatchers.Main)
  var person : Person? by mutableStateOf(null) //Returned Person. Possible none.

  //INSERT PERSON
  fun insertPerson(person: Person) {
    coroutineScope.launch(Dispatchers.IO) {
      productDao.insertPerson(person)
    }
  }

  //DELETE PERSON
  fun deletePerson(name: String) {
    coroutineScope.launch(Dispatchers.IO) {
      productDao.deletePerson(name)
    }
  }

  //SELECT PERSON
  fun findPersonById(id: Int) {
    coroutineScope.launch(Dispatchers.Main) {
      person = asyncFind(id).await()
    }
  }
  private fun asyncFind(id: Int): Deferred<Person?> =
    coroutineScope.async(Dispatchers.IO) {
      return@async productDao.findPersonById(id)
    }

}

