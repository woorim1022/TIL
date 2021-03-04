//analogWrite 테스트, 0~255 중 어떤 값을 주냐에 따라 밝기가 달라짐

void setup() {
  // put your setup code here, to run once:
  pinMode(11,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  //0~255
  for(int i = 0;i<256;i++){
     analogWrite(11,i);
     delay(10);
  }
  for(int i = 255;i>=0;i--){
     analogWrite(11,i);
     delay(10);
  }
  //analogWrite(11,255); //켜진상태(밝은불)
  //analogWrite(11,127); //켜진상태(중간밝기 불)
  //analogWrite(11,0); //꺼진상태
}
