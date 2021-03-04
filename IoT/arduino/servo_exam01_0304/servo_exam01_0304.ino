// 서브모터 테스트
#include <Servo.h>

Servo myServo;

int btn1 = 13;
int btn2 = 12;
int btn1_state = 1;
int btn2_state = 1;
int angle = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  myServo.attach(6);
  pinMode(btn1,INPUT);
  pinMode(btn2,INPUT);
}

void loop() {
  myServo.write(angle);
  btn1_state = digitalRead(btn1);
  btn2_state = digitalRead(btn2);
  Serial.println(btn1_state);
  Serial.println(btn2_state);
  if(btn1_state==0){ 
    angle+=20;
    myServo.write(angle);
  }
  else if(btn2_state==0){
    angle-=20;
    myServo.write(angle); 
  }
  delay(1000);
}
