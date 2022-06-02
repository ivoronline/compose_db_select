package com.ivoronline.compose_db_select

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

  //INSERT PERSON
  @Insert
  fun insertPerson(product: Person)

  //DELETE PERSON
  @Query("DELETE FROM person WHERE name = :name")
  fun deletePerson(name: String)

  //SELECT PERSON
  @Query("SELECT * FROM Person WHERE id = :id")
  fun findPersonById(id: Int): Person

}


