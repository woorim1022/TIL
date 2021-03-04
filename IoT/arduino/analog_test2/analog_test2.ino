//아날로그 핀 & 가변저항 테스트
//가변저항 0~1023
int led_pin=11;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(led_pin, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int inputVal = analogRead(A0);
  Serial.println(inputVal);
  //가변저항값이 500이 넘으면 led불이 켜지도록
  //500이하값이면 불이 꺼지도록
  if(inputVal > 500){
    digitalWrite(led_pin,HIGH);
  }else{
    digitalWrite(led_pin,LOW);
  }
  delay(500);
}
