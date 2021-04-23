package http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iot.R
import com.example.mqttclienttest.network.BoardData
import kotlinx.android.synthetic.main.activity_http_test.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

//파이썬 장고 웹서버에서 오픈한 http://192.168.0.197:8000/list에 접속해서 데이터 가져오기
class HttpTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_test)
        button.setOnClickListener{
            thread{
                //네트워크를 통해 데이터를 요청하는 경우는 무조건 스레드 처리한다.
                //접속할 주소
                val site = "http://192.168.0.197:8000/list"
                //주소를 사용할 수 있도록 객체로 정의
                val url = URL(site)

                //접속하기 - openConnection이 리턴하는 객체를 하위객체로 변환
                //openConnection이 URLConnection을 리턴 하지만 구체적인 기능을 사용하기 위해서 자식객체인
                // HttpURLConnection으로 변경
                val con = url.openConnection() as HttpURLConnection // HttpURLConnection으로 캐스팅(객체를 변환하는것)

                //네트워크를 통해 전송되어 오는 데이터를 읽어서 처리하기 위한 안드로이드의 입력스트림클래스를
                //선언하고 처리
                //byte로 전송 -> 한글이 있으므로 문자단위 처리로 변경
                //byte단위 처리 클래스로 문자단위 처리 클래스를 생성
                //InputStreamReader은 기본처리만 가능
                //inputStream으로 바로 BufferedReader를 바로 생성할 수 없기 때문에 InputStreamReader로 중간에 한번 감싸준다.
                val isr = InputStreamReader(con.inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null //String으로 문자열을 표현하면 객체가 너무 만들어진다.
                val buf = StringBuffer() //String 보다 리소스를 적게 사용하므로 네트워크에서 처리되는 문자열은
                                        //StringBuffer로 작업
                do{
                    str = br.readLine() //버퍼에 있는 모든 내용을 일거오기 - 한 라인씩 읽기
                    if(str != null){
                        buf.append(str)
                    }
                }while(str!=null) //네트워크로 전송되는 데이터를 읽어서 StringBuffer에 저장하기
                val data = buf.toString()
                //JSON 객체를 파싱하는 작업을 처리
                //JSONArray객체로 받아서 JSONArray에 저장된 JSONObject의 갯수만큼 처리
                //[ ] -> json데이터에서 array
                //{ } -> json데이터에서 object

                val root = JSONArray(data)
                for(i in 0 until root.length()){
                    //i번째 JSONObject를 추출해서 Board로 변환
                    var jsonobj = root.getJSONObject(i)
                    var dto = BoardData(jsonobj.getInt("boardNo"),
                                        jsonobj.getString("title"),jsonobj.getString("content"),
                                        jsonobj.getString("title"),jsonobj.getString("write_date"))
                    runOnUiThread{
                        textView2.append(dto.toString()+"\n")
                    }
                }
            }
        }
    }
}