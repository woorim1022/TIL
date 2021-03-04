//pwm 테스트

void setup() {
  // put your setup code here, to run once:
  pinMode(11,OUTPUT);
}

void loop() {
  // ADC - 아날로그를 디지털로 바꾸기 위한 장치(내부에 포함) : 10비트 1023
  //pwm 8bit - 0~255까지
  //불 켜
  digitalWrite(11,1);
  delay(1);//10% - duty 사이클이 10%
  //불 꺼
  digitalWrite(11,0);
  delay(9);//90%
}
