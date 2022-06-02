package com.ivoronline.compose_db_select

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
class Person {

  //PROPERTIES
  @PrimaryKey(autoGenerate = true)
  var id  : Int    = 0
  var name: String = ""
  var age : Int    = 0

  //CONSTRUCTORS
  constructor() {}

  constructor(name: String, age: Int) {
    this.name = name
    this.age  = age
  }

}
