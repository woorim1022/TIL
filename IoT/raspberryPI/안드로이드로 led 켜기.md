# 안드로이드로 led 켜기

### 1. python 으로 subscriber, publisher 

* 파이썬 라이브러리 연결

  * paho

*  Subscriber개발(메세지수신자)

  * MQTT 클라이언트 클래스 객체생성

    ```python
    Client()
    client_id # 브로커에 클라이언트가 연결될 때 사용되는 고유한 id문자열
    clean_session # 브로커와연결이 끊어졌을 때 클라이언트의 정보를 지울지 여부를 결정
    userdata # 사용자데이터
    protocol # MQTT의 버전(MQTTv311 or MQTTv31)
    transport # 데이터를 전송하는 프로토콜(tcp or websoket)
    ```

  * 브로커에 연결해서 토픽에 대한 구독을 신청

  * 토픽이 연결되면 실행할 핸들러함수를 등록

    * 브로커에 연결해서 토피겡 대한 구동을 신청

  * 토픽이 수신되면 실행할 핸들러함수를 등록

    * 토픽이 수신되면 처리할 작업들을 구현(led나 sensor등 라즈베리파이에 연결된 장비제어)

  * subscriber를 브로커에 연결하기

    connect()

    ​	host : 브로커의 ip

    ​	port : 브로커의 port

    ​	keepalive : 브로커와 통신할 때 허용하는 최대시간

  * 토픽이 수신될 때 까지 대기

  * 토픽이 수신되면 핸들러함수가 실행되도록 처리

* publisher 개발

### 2. 안드로이드로 subscriber, publisher 

* android에서 MQTT통신을 위해 사용하는 핵심클래스	

 	1. **MqttAndroidClient**		
     * android에서 MQTT통신을 하기 위한 클라이언트 객체
	2. **MqttConnectOptions**
    * 클라이언트가 서버에 연결하는 방법을 설정할 수 있는 객체
	3. **IMqttActionsListener**
    * 리스너
    * broker에 연결되거나 실패할 때 자동으로 실행되는 객체

### 3. 라즈베리파이로 led제어





### 전원에서 그라운드로 연결 절대 ㄴㄴㄴ







