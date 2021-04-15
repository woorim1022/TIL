from flask import Flask, render_template, request, Response, jsonify
import RPi.GPIO as GPIO
import random

app = Flask(__name__)
GPIO.setmode(GPIO.BCM)
LED = 20
GPIO.setup(LED,GPIO.OUT, initial=GPIO.LOW)

# 10초마다 한번씩 센서값을 추출해서 넘겨주기 위한 메소드
# 추출한 데이터를 json 형식으로 변환해서 리턴
@app.route("/update")
def update():
    msg = {
        "hum": random.randrange(40, 60),
        "temp": random.randrange(20, 25),
        "distance": random.randrange(20, 50)
    }
    return jsonify(msg)

# 최초실행할 때 호출될 path 에 따른 처리 메소드
@app.route("/<command>")
def action(command):
    if command == "on":
        GPIO.output(LED,GPIO.HIGH)
        message = "GPIO" + str(LED) + "ON"
    elif command == "off":
        GPIO.output(LED, GPIO.LOW)
        message = "GPIO" + str(LED) + "OFF"
    else:
        message = "Fail"
    # 초음파센서, 온도습도 센서의 값을 읽어서 연결
    # mongodb에 저장하기
    msg = {
        "message": message,
        "status": GPIO.input(LED),
        "hum": random.randrange(40,60),
        "temp": random.randrange(20,25),
        "distance": random.randrange(20,50)
    }
    return render_template("index.html", **msg)


if __name__ == "__main__":
    try:
        app.run(host="0.0.0.0", debug=True)
    except KeyboardInterrupt:
        print("종료")
        GPIO.cleanup()
