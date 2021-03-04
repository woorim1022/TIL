//for문을 이용하여 수정하기
int time = 500;
int led_pin[3]={7,5,2};
int pin=0;//현재 불을 켜기 위해서 led번호를 저장할 변수
void setup() {
  Serial.begin(9600);
  for(int i=0;i<3;i++){
    pinMode(led_pin[i], OUTPUT);
  }
}

// the loop function runs over and over again forever
void loop() {
    if(Serial.available()>1){
      String data = Serial.readStringUntil("\n");
      Serial.println(data);
      if(data=="A0"){
        pin = led_pin[0];
        Serial.println("A0입력");
      }else if(data=="A1"){
        pin = led_pin[1];
        Serial.println("A1입력");
      }else{
        pin = led_pin[2];
        Serial.println("A2입력");
      }
      led_allOff();
      led_on(pin);
    }
}

//ledon - 전달받은 핀 번호에 해당하는 led on
void led_on(int pin){
  digitalWrite(pin,HIGH);
}
//- 전달받은 핀 번호에 해당하는 led off
void led_off(int pin){
  digitalWrite(pin,LOW);int push_btn = 12;
int led = 10;
int btn_state = 0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
  pinMode(led,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(1000);
  btn_state = digitalRead(push_btn);
  Serial.println(btn_state);
  if(btn_state==HIGH){  //모니터상0
    digitalWrite(led,HIGH);
  }else{                //모니터상1
    digitalWrite(led,LOW);
  }
}
}
//모든 led off
void led_allOff(){
  for(int i=0;i<3;i++){
    digitalWrite(led_pin[i],LOW);
  }
}
