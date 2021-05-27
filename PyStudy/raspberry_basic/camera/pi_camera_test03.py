from picamera import PiCamera
from time import sleep

# 파일로 저장하기
camera = PiCamera()
# 사진을 180도 회전해서 출력한다.
camera.rotation = 180
camera.start_preview()
sleep(10)

for i in range(5):
    sleep(2)
    camera.capture('/home/pi/whoareyou/images/image%d.jpg' % i)

camera.stop_preview() # 미리보기 화면 정지

