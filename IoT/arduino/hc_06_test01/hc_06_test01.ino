#include <SoftwareSerial.h>
//아두이노에 연결한 tx, rx 번호와 cross 되게 연결해야 된다.
#define rxPin 2
#define txPin 3
//swSerial(rxPin, txPin);
SoftwareSerial swSerial(rxPin, txPin); //(2,3)
char data;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  swSerial.begin(9600);
  Serial.println("ready...");
}

void loop() {
  //시리얼 버퍼를 비우는 작업
  Serial.flush();

  
  Serial.println("command:");
  //사용자가 데이터를 입력할 때 까지 대기 - 버퍼에 값이 들어올때까지 대기
  while(!Serial.available());
  //++++++HC_06에 명령어를 전송++++++++
  while(Serial.available()){
    data = Serial.read(); //키보드로 입력하는 블루투스 명령어를 읽어서  
    if (data==-1){
      break;
    }
    swSerial.print(data); //블루투스에 명령어를 전달
    Serial.print(data);
    delay(1);
  }
  Serial.println();
  //HC_06(블루투스모듈)이 명령어를 받아서 처리할 시간
  delay(1000);

  
  Serial.println("return:");
  //++++++HC_06으로 부터 전송된 데이터를 화면에 출력++++++++
  while(swSerial.available()){
    data = swSerial.read();  
    if (data==-1){
      break;
    }
    Serial.print(data); 
    delay(1);
  }
  Serial.print("\n\n\n");
}
