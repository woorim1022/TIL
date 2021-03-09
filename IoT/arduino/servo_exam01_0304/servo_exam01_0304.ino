//과제
//스위치 2개를 이용해서 서보모터 각도를 제어
//스위치 1개는 각도가 20도씩 + 되도록 구현
//스위치 1개는 각도가 20도씩 - 되도록 구현
//풀업으로 구현
//최대각도 : 180, 최소각도 : 0
#include <Servo.h>

Servo myServo;

int btn1 = 13; //+용 버튼
int btn2 = 12; //-용 버튼
int btn1_state = 1; //버튼이 눌려졌는지 판단하기 위한 상태값
int btn2_state = 1; //버튼이 눌려졌는지 판단하기 위한 상태값
int angle = 0; //서보모터에 셋팅할 각도

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
  if(btn1_state==0){ 
    if (angle < 180)
      angle+=20;
    Serial.println("+버튼:" + (String)angle);
    myServo.write(angle);
  }
  else if(btn2_state==0){
    if (angle > 0)
      angle-=20;
    Serial.println("-버튼:" + (String)angle);
    myServo.write(angle); 
  }
  delay(300);
}
