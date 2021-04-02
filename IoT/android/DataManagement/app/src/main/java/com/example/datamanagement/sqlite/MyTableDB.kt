package com.example.datamanagement.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

//test.db 파일에 저장된 mytable테이블에 CRUD 기능을 처리하는 객체
class MyTableDB {
    var mydb: SQLiteDatabase?= null
    var contentValObj:ContentValues ?= null
    constructor(context: Context){
        var helper = DBHelper(context)

        //getWritableDatabase()를 호출해서 SQLiteDatabase객체를 만들기
        mydb = helper.writableDatabase
    }
    fun insert(person: Person){
        //데이터 저장하기
        //매개변수로 전달된 Person객체에 저장된 데이터를 SQLite에 insert하기
        contentValObj = ContentValues()
        contentValObj!!.put("id",person.id)
        contentValObj!!.put("name",person.name)
        contentValObj!!.put("age",person.age)
        //insert내부에서 insert 기능을 처리할 수 있는 sql문을 생성한다. 이때 필요한 컬럼에 전달할 값 등은 ContentValues에서 추출
        mydb?.insert("mytable",null,contentValObj)

    }
    fun select(){

    }
    fun update(){

    }
    fun delete(){

    }
}