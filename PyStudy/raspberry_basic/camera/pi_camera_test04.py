from picamera import PiCamera, Color
from time import sleep

# 파일로 저장하기
camera = PiCamera()
# 사진을 180도 회전해서 출력한다.
camera.rotation = 180
camera.start_preview()

camera.annotate_text_size = 50
camera.annotate_background = Color('blue')
camera.annotate_foreground = Color('yellow')
camera.annotate_text = "    raspberry pi  "

sleep(10)
camera.capture('/home/pi/iot/image.jpg')
    
camera.stop_preview() # 미리보기 화면 정지

