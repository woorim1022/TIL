package thread

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.iot.R
import kotlinx.android.synthetic.main.main.*
import kotlin.concurrent.thread

class ThreadTestActivity : AppCompatActivity() {
    lateinit var handler1: Handler
    lateinit var handler2: Handler
    var progressVal :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        //작업 요청을 의뢰받아 화면을 변경할 핸들러객체를 정의
        //Looper가 작업요청을 기다리고 있다가 작업 처리 요청이 들어오면 작업을 처리하기 위한 일을 수행하는 객체
        handler1 = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                //여기에서 스레드에서 전달한 값으로 혹은 스레드에서 변경한 값으로 화면을 변경하는 작업
                textView.text = "progressbar 진행율:$progressVal"
                progressBar.incrementProgressBy(1)
            }
        }
        //worker 스레드에서 전달하는 메시지를 가지고 작업
        handler2 = object : Handler(Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                when(msg.what){
                    0 ->  textView.text = "progressbar 진행율:${msg.arg1}"
                    1 -> progressBar.progress = msg.arg1
                }
            }
        }

    }
    //변경할 뷰의 정보나 다른 값들을 handler에게 전달해야 하는 경우
    //Message객체를 이용해서 작업한다.
    //Message객체의 멤버 중에 what은 구분하기 위한 값, arg1은 value를 저장
    fun userMessageHandler(view: View){
        thread {
            for (i in 1..100) {
                val mymsg = Message()
                if(i%2==0){
                    mymsg.what = 0  //핸들러가 작업을 의뢰한 스레드를 구분하기 위한 값을 저장
                }else{
                    mymsg.what = 1
                }
                mymsg.arg1 = i //전달할 데이터
                handler2.sendMessage(mymsg)
                SystemClock.sleep(10)
            }
        }
    }
    fun useHandler(view : View){
        //오래걸리는 작업을 처리
        thread{
            //블럭 안에 오래 걸리는 작업을 구현
                for (i in 1..100) {
                    progressVal = i
                    SystemClock.sleep(1000)
                    //handler가 갖고 있는 Message객체를 매개변수로 전달하면서 작업을 의뢰
                    handler1.sendMessage(handler1.obtainMessage())
                }

        }
    }
    /*
    * 긴 시간 동안 실행하며 view를 변경하는 작업은 실행되는 동안 다른 작업을 할 수 없으므로
    * 안드로이드에서는 5초동안 반응하지 않으면 어플리케이션을 강제종료한다.
    * ANR(Application Not Responding)
    * 오랜 시간동안 작업해야 하는 것을 UI 스레드에서 정의하면 안된다.
    *                               -----------
    *                                   화면을 구성하고 이벤트를 대기하는 스레드로 처음 실행하면 만들어지는 스레드
    *                                   별도의 스레드를 만들어서 작업해야 한다.
    *                                   UI를 변경하는 작업은 무조건 UI 스레드에서 처리
    *                                   사용자가 만든 스레드에서 UI를 변경하면 안된다.
    *                                   -------------------
    *                                       worker Thread
    *                                       1. Handler의 이용
*                                               => woker 스레드에서 화면에 대한 처리 작업을 Handler에게 의뢰
*                                               1) 오래걸리는 작업을 동일하게 worker스레드로 구현
*                                               2) UI 스레드에서 Handler객체를 구현
*                                           2. runOnUiThread
*                                           3. 28버전 이하 - AsyncTask
*                                           4. retrofit
    * */
    // 잘못된 작업
    fun btnNoThread(view: View){
        for(i in 1..100){
            progressBar.progress = i
            SystemClock.sleep(1000)
        }
    }
    fun useThread(view : View){
        /*쓰레드를 작성
        * 쓰레드 안에서 오래 걸리는 작업이 실행되도록
        * 쓰레드를 start*/
        thread{
            //블럭 안에 오래 걸리는 작업을 구현
            for (i in 1..100) {
                progressBar.progress = i
                SystemClock.sleep(1000)
            }
        }
    }
}
