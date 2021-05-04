# 라즈베리파이 영상정보처리 & mongodb



* raspistill -o myimage.jpg
  * 상하좌우 방향 맞춘 사진

* raspistill -vf -hf -o myimage.jpg
  * 상하좌우 방향 맞춘 사진

* raspivid -o vid.h264
  * 5초짜리 영상
* raspivid -o vid.h264 -t 10000
  * 10초짜리 영상











#### Flask 

```python
from flask import Flask


app = Flask(__name__)

# 데코레이터
# 요청 패스를 준다
@app.route("/")
def hello():
    return "Hello Raspberry Pi IoT Project"

# flask를 실행하기 위한 기본 port 5000
app.run()
# flask를 실행하기 위한 기본 port 5000
# app.run(host="0.0.0.0", port="8088")

```











#### Mongodb

* 파일

  * mongo.exe : 클라이언트파일
  * mongod.exe : 서버파일

* 실행

  1. cmd창 2개 띄운다(서버용, 클라이언트용)
  2. mongod --dbpath C:\iot\data, mongo 실행

* 사용

  1. DB생성

     * 몽고디비에서 생성된 디비확인 
       * show dbs
     * 디비사용
       * use 디비명

  2. collection생성

     * collection확인 
       * show collections
     * collection생성
       * db.createCollection("컬렉션명")
     * collection명 변경
       * db.emp.renameCollection("변경할이름")
     * collection 삭제
       * db.dept.drop()

  3. 데이터관리

     1. 데이터저장(insert)
        [형식]

        db.컬렉션명. inesert({저장하고싶은데이터})

        * insert 하면 collection이 없는 경우 새로 만들어서 insert

        * _id 가 기본키 역할

           "_id" : ObjectId("606ff148446bff390ad1583c")

          ​							=========================

          ​			현재 timestamp + machine id + mongodb의 프로세스 id + 시퀀스번호

        * 데이터 입력하기

          db.emp.insert({_id:"1223",id:"jang",name:"장동건"})

          [] -> 배열

          {} -> object

          [배열 이용해서 insert]

          * object를 배열로 관리

            db.emp.insert([{id:"1234jang",val1:2000,val3:1000},

            ​							{id:"kang",val1:2000,val3:1000,name:"강감찬"},

            ​							{id:"lee",val1:2000,val3:1000,name:"이민호",data:"test111"}])

          * 값을 배열로 삽입

            db.emp.insert({id:"1234jang",val1:2000,val3:1000,city:["강릉","대구","부산"]})

     2. 조회

        *  db.exam.find({}) 
          * 전체조회

     