// 서브모터 테스트
#include <Servo.h>

Servo myServo;

void setup() {
  // put your setup code here, to run once:
  myServo.attach(6);
}

void loop() {
  // put your main code here, to run repeatedly:
  for(int i = 0;i<=180;i++){
    myServo.write(i);
    delay(20);    
  }

}
