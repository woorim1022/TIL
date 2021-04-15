# 0415



### 몽고디비 라즈베리파이에 설치

* 설치

  ```bash
  sudo apt-get install mongodb-server
  ```

* 데이터폴더 생성

  ```bash
  mkdir mongo
  ```

* dbpath 경로 설정

```bash
sudo nano /etc/mongodb.conf
```

```bash
# Where to store the data.
dbpath=/home/pi/iot/mongo

#where to log
logpath=/var/log/mongodb/mongodb.log

logappend=true

bind_ip = 192.168.0.198
#port = 27017

```

* 디비 실행

```bash
$ sudo service mongodb start 
  ---> 시작하는 명령어
$ sudo service mongodb stop
  ---> 종료하는 명령어
```



* 클라이언트 실행

```bash
mongo	
```

