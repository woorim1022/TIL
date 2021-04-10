from flask import Flask


app = Flask(__name__)

# 데코레이터
# 요청 패스를 준다
@app.route("/")
def hello():
    return "Hello Raspberry Pi IoT Project"

# flask를 실행하기 위한 기본 port 5000
app.run(host="0.0.0.0", port="8088")

