int push_btn = 12;
int led = 10;
int btn_state = 0;
int flag = 0;
int flag = 0;
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
  if(btn_state==1){  
    if(flag == 1){
      digitalWrite(led,LOW);
      flag = 0;
    }else{
      digitalWrite(led,HIGH);
      flag = 1;
    }
  }
  delay(1000);
}
