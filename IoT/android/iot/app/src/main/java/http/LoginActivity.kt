package http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.iot.R
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.*
import org.json.JSONObject
import kotlin.concurrent.thread

class LoginActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener{
            thread {
                //EditText에 입력한 id와 pass로 json 데이터를 만들기
                var jsonobj = JSONObject()
                jsonobj.put("boardNo",id.text)
                jsonobj.put("writer",pass.text)
                val json:String = jsonobj.toString()

                val site = "http://192.168.0.197:8000/login"
                //접속하기 위한 객체를 생성
                val client = OkHttpClient()

                //Request 정보를 담은 Request 객체 만들기
                //url(), post(), build() 셋 다 Builder()의 메서드
                //풀어서 쓰면,
//                var builder = Request.Builder()
//                builder = builder.url("")
//                builder = builder.post(null)
//                val req = builder.build()
                val request: Request = Request.Builder().url(site).post(RequestBody.create(MediaType.parse("application/json"),json)).build()

                //요청하기
                val response: Response = client.newCall(request).execute()
                val result = response.body()!!.string() //response의 body 를 추출
                Log.d("msg",result)
            }
        }
    }
}