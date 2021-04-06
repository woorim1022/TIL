package com.example.datamanagement.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.dbjob_main.*
import java.lang.Integer.parseInt

class ContentValuesTestActivity : AppCompatActivity() {
    var dao:MyTableDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dbjob_main)

        dao = MyTableDB(this)

        save.setOnClickListener {
            var myperson = Person(id.text.toString(), name.text.toString(),parseInt(age.text.toString()))
            dao?.insert(myperson)
            id.setText("")
            name.setText("")
            age.setText("")
            Toast.makeText(this, "삽입성공", Toast.LENGTH_LONG).show()
        }
    }
}