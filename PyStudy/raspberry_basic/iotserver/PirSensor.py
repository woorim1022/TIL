from threading import Thread
import paho.mqtt.client as mqtt
import time
import RPi.GPIO as GPIO




class Pir(Thread):
    def __init__(self,client,value):
        super().__init__()
        self.value = ""
        self.client = client

    def run(self):
        while True:
            GPIO.setmode(GPIO.BCM)
            pirPin = 26
            GPIO.setup(pirPin, GPIO.IN)
            time.sleep(2)
            if GPIO.input(pirPin) == 1:
                self.value = 'motion detect'
                print("on")
            else:
                self.value = 'off'
                print("off")

            # 실제로 만들때는
            # 무조건 publish하게 만들지 말고 한 다섯번정도 모션 detectec가 왔을때 publish를 한다던지 publish할 조건을 준다.
            self.client.publish("iot/pir", self.value)
            #self.client.loop(2)
