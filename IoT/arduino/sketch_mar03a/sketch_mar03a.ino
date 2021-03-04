int inputdata = 0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()>0){
    inputdata = Serial.read();
    Serial.write(inputdata);
    //white함수는 1을 그대로 전송해서 시리얼모니터에서 아스키로 해석해서 출력
    Serial.write(1);
    Serial.print(",");
    //print함수는 1값을 아스키코드로 해석해서 데이터를 전송
    Serial.print(1);
    Serial.println(inputdata);
  }
}
