//안드로이드 블루투스 시리얼 컨트롤러 앱에서 입력한 값을 시리얼모니터에 출력

#include <SoftwareSerial.h>
//아두이노에 연결한 tx, rx 번호와 cross 되게 연결해야 된다.
#define rxPin 2
#define txPin 3
//swSerial(rxPin, txPin);
//블루투스 전달되는 데이터(안드로이드폰)를 시리얼모니터에 출력
String mystr = "";
SoftwareSerial swSerial(rxPin, txPin); //(2,3)
char data;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  swSerial.begin(9600);
  Serial.println("ready...");
}

void loop() {
  delay(100);
  while(swSerial.available()){
    char myChar = swSerial.read();
    mystr += myChar;
  }
  if(!mystr.equals("")){
    Serial.println("input data:"+mystr); 
  }
  mystr="";//mystr을 초기화
}
