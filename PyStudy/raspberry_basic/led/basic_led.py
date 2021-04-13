import RPi.GPIO as GPIO
import time
# GPIO의 핀모드를 설정
# BCM: 핀번호를 BCM모드, BOARD로 정의하면 물리적인 핀번호
GPIO.setmode(GPIO.BCM)
LED = 21

# LED로 정의한 21번을 GPIO의 output핀으로 사용하겠다고 정의
GPIO.setup(LED,GPIO.OUT,initial=GPIO.LOW)
# 21번으로 출력
GPIO.output(LED,GPIO.HIGH)
