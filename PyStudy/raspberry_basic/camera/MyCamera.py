from flask import Flask, render_template, request, Response
import RPi.GPIO as GPIO
import picamera
import time
import io
import threading
app = Flask(__name__)
GPIO.setmode(GPIO.BCM)
LED = 20
GPIO.setup(LED,GPIO.OUT, initial=GPIO.LOW)

# Camera 클래스는 비디오 스트리밍 - 하나의 프로세스 안에서 독립적인 실행흐름으로 처리하기 위해 스레드로 처리
class Camera:
    thread = None
    frame = None
    start_time = 0
    # streaming이라는 메소드를 스레드로 관리하고 화면으로 보내주는 함수
    def getStreaming(self):
        Camera.start_time = time.time()
        if Camera.thread is None:
            # 백 그라운드의 스레드를 시작 - 스레드로 작업하기 위해 Thread클래스를 생성해서 작업
            # ===> 클래스를 만들때 Thread 클래스를 상속받아 만들 수 있다.
            # streaming메소드의 실행을 쓰레드로 처리하겠다는 의미
            Camera.thread = threading.Thread(target=self.streaming)
            Camera.thread.start() # 쓰레드를 시작하겠다는 의미
            while self.frame is None:
                time.sleep(1)
        return self.frame
    # 독립적인 실행의 한 단위로 파이카메라로 찍은 영상을 프레임단위로 지속적으로 보내주는 역할을 하는 메소드
    @classmethod
    def streaming(c):
        with picamera.PiCamera() as camera:
            camera.resolution = (480, 320)
            camera.hflip = True
            camera.vflip = True

            camera.start_preview()
            time.sleep(2)

            stream = io.BytesIO()
            # capture_continuous :
            # (stream, "jpeg", use_video_port=True) : 캡쳐한 내용을 jpeg형식으로 스트림에 계속 넣어주겠다는 의미
            for f in camera.capture_continuous(stream, "jpeg", use_video_port=True):
                stream.seek(0)  # 파일의 맨 처음 위치로 커서를 이동
                c.frame = stream.read()
                stream.seek(0)
                stream.truncate()   # 파일의 내용을 비움움

