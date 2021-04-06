package gatewaydevicecontrol_exam

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

const val DB_VERSION = 2
class DBHelper  : SQLiteOpenHelper {

    constructor(context: Context) : super(context,"test.db",null,DB_VERSION)

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("@@@@","데이터베이스가 생성되었습니다.")
        val sql = """
            create table job(
                idx integer primary key autoincrement,
                date text,
                id text,
                ledstate text
            )
        """.trimIndent()
        //sql문을 실행
        db?.execSQL(sql)
    }







    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}