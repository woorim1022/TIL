from picamera import PiCamera
from time import sleep

# 동영상 파일로 저장하기
camera = PiCamera()
camera.rotation = 180
camera.start_preview()

# 동영상 저장 시작
camera.start_recording("/home/pi/iot/video.h264")
sleep(10)
camera.stop_recording()

camera.stop_preview() # 미리보기 화면 정지

