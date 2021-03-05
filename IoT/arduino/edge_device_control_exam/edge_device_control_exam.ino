#include <Servo.h>

Servo myServo;

int btn = 12;
int servo = 6;
int pir = 7;
int btn_state = 0;

int angle = 0;

void setup() {
  Serial.begin(9600);
  pinMode(pir,INPUT);    // pir 센서
  myServo.attach(servo);   //서보모터
  pinMode(btn,INPUT); //스위치
  myServo.write(0);
}

void loop() {
  
  btn_state = digitalRead(btn);
  int pirvalue = digitalRead(7);
  //센서 값이 1일 때`
  if (pirvalue == 1){
     Serial.println("PIR 센서값 : " + (String)pirvalue);
     angle = 90;
     myServo.write(angle);
     Serial.println("출입문이 열립니다.");
  }
  else{
     //버튼 눌렀을 때
    if(btn_state==1){ 
      Serial.println("버튼 클릭");
      //열려있으면 닫는다
      if (angle == 90){
        angle = 0;
        Serial.println("출입문이 닫힙니다.");
      }
      //닫혀있으면 연다
      else if(angle == 0){
        angle = 90;
        Serial.println("출입문이 열립니다.");
      }
      myServo.write(angle);
    }
  }
  delay(1000);
}
