//가변저항으로 led의 밝기 조절

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(11,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int inputVal = analogRead(A0);
  
//  int convertVal = (float)inputVal * 255/1023;
  // map() - 입력값으로 전달되는 값의 범위를 이용해서 원하는 범위 값으로 변경할 수 있도록 지원하는 함수
  int convertVal = map(inputVal,0,1023,0,255);
  analogWrite(11,convertVal);
  Serial.println(inputVal);
  Serial.println("\t");
  Serial.println(convertVal);
  delay(100);
}
