import  time
import Adafruit_DHT as dht11
sensor = dht11.DHT11
pin = 17
while True:
    hum,temp = dht11.read_retry(dht11.DHT11, pin)
    if hum is not None and temp is not None:
        ### 여기서 온도, 습도값을 mqtt로 서버에 전달
        ### 몽고디비에 저장
        print(str(hum)+","+str(temp))
    else:
        print("error")
    time.sleep(1)