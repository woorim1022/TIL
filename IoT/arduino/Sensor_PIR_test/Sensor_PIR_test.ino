void setup() {
  Serial.begin(9600);
  pinMode(7,INPUT);
  pinMode(13,OUTPUT);
}

void loop() {
  int value = digitalRead(7);
  if (value == 1){
    digitalWrite(13,HIGH);
  }else{
    digitalWrite(13,LOW); 
  }
  Serial.println(value);
  delay(100);
}
