package com.example.datamanagement.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import gatewaydevicecontrol_exam.DBHelper
import gatewaydevicecontrol_exam.Job
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

//test.db 파일에 저장된 mytable테이블에 CRUD 기능을 처리하는 객체
class MyTableDB {
    var mydb: SQLiteDatabase?= null
    var contentValObj:ContentValues ?= null
    constructor(context: Context){
        var helper = DBHelper(context)

        //getWritableDatabase()를 호출해서 SQLiteDatabase객체를 만들기
        mydb = helper.writableDatabase
    }
    fun insert(job: Job){

        contentValObj = ContentValues()
        contentValObj!!.put("date",job.date)
        contentValObj!!.put("id",job.id)
        contentValObj!!.put("ledstate",job.ledstate)
        //insert내부에서 insert 기능을 처리할 수 있는 sql문을 생성한다. 이때 필요한 컬럼에 전달할 값 등은 ContentValues에서 추출
        mydb?.insert("job",null,contentValObj)

    }
    fun select():ArrayList<Job>{
        val joblist = ArrayList<Job>()
        var sql = "select * from job"
        val cursor: Cursor = mydb!!.rawQuery(sql,null)
        while(cursor.moveToNext()){ //테이블내부에서 커서를 다음 레코드로 이동(레코드가 존재하면true, 없으면 false를 리턴)
            val idx = cursor.getInt(0)
            val date = cursor.getString(1)
            val id = cursor.getString(2)
            val ledstate = cursor.getString(3)
            joblist.add(Job(date, id, ledstate))
        }
        return joblist
    }
    fun update(){

    }
    fun delete(){

    }
}