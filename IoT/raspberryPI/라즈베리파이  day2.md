# 라즈베리파이  day2

#### 패키지 업데이트, 업그레이드 

```bash
sudo apt-get update
/설치 되어있는 패키지들의 새로운 버젼이 있는지 확인할 때 해당 명령어를 사용합니다.
sudo apt-get upgrade
/위에 있는 apt-get update를 통해서 확인한 패키지들의 최신 버전에 따라서 패키지들의 버전을 업그레이드 해주는 명령어입니다.

sudp raspi-config
```



#### 리눅스

##### 디렉터리구조

* / : 루트
* /bin : binaries, 리눅스 가장 기본이 되는 명령어들이 모여있는 디렉터리

##### 명령어

* ls : 현재 디렉터리의 리스트 확인
  * -a 옵션 : 숨김파일(.파일명) 확인
* cd : change diractory
  * .. : 상위
  * / : 최상위
  * ~ : 홈

* sudo (superuser do) 
  *  현재 계정에서 root 권한을 이용하여 명령어를 실행할 때 사용
* sudo -i 또는 sudo -s
  * i, s 옵션을 사용하여 sudo 명령도 su처럼 root 계정으로 전환이 가능하다.
* apt-get(Advanced Packaging Tool)
  *  우분투(Ubuntu)를 포함안 데비안(Debian)계열의 리눅스에서 쓰이는 패키지 관리 명령어 도구
  * apt를 이용해서 설치된 deb패키지는 /var/cache/apt/archive/ 에 설치가 됩니다.





#### vnc 뷰어 설치

* gui 제공





#### MQTT(Messege Queuing Telemetry Transport)

	* 메시징 프로토콜
	* M2M, IoT분야에 적용
	* 장치들 간에 메세지를 주고 받을 때 사용하는 프로토콜 

 * 브로커
   	* 주고받는 메세지를 중개해주는 역할
 * 퍼블리셔
   	* 브로커에게 메세지를 보냄
   	* 주제(topic)을 정해서 메세지를 보내면 브로커를 통해 서브스크라이버가 수신
 * 서브스크라이버

<img src="C:\Users\USER\Desktop\TIL\IoT\raspberryPI\md_images\캡처.PNG" alt="캡처" style="zoom:60%;" />

* mosquitto 
  * 브로커, 퍼블리셔, 서브스크라이버 만들어주는 프로그램

<img src="C:\Users\USER\Desktop\TIL\IoT\raspberryPI\md_images\캡처2.PNG" alt="캡처2" style="zoom:40%;" />

* publisher

<img src="C:\Users\USER\Desktop\TIL\IoT\raspberryPI\md_images\캡처3.PNG" alt="캡처2" style="zoom:40%;" />