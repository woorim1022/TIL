//필요부품 : RGB LED, 스위치, 가변저항
//스위치를 이용해서 RGB를 선택하고 가변저항을 이용해서
//RGB LED에 설정할 RGB 값을 생성해서 RGB LED에 불이 들어오도록 설정하기
//조건 : push 풀다운
//map()사용해서 변환

int flag = 0;
int push_btn = 13;
int btn_state = 0;
int red = 11;
int blue = 10;
int green = 9;

void setup() {
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
  pinMode(red,OUTPUT);
  pinMode(blue,OUTPUT);
  pinMode(green,OUTPUT);
}

void loop() {
  int inputVal = analogRead(A0);
  int convertVal = map(inputVal,0,1023,0,255);
  Serial.println(convertVal);
  btn_state = digitalRead(push_btn);
  if(btn_state==1){  
    if(flag==0){
      analogWrite(red,convertVal);
      flag = 1;
    }else if(flag==1){
      analogWrite(blue,convertVal);
      flag = 2;
    }else{
      analogWrite(green,convertVal);
      flag = 0;
    }
  }
  delay(1000);
}
