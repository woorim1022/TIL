int led[3] = {13, 12, 11};
int inputdata = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  for(int i = 0; i < 3; i++)
      pinMode(led[i], OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()>0){
    inputdata = Serial.read();
    for(int i = 0; i < 3; i++){
      Serial.write("for:");
      Serial.write(inputdata);
      if(inputdata == int(i)){
        Serial.write("if:");
        Serial.write(i);
        ledon(inputdata);
        ledoff(inputdata);
      }
    } 
  }
 
}



void ledon(int i){
    digitalWrite(led[i], HIGH);
    delay(1000);
}

void ledoff(int i){
      digitalWrite(led[i], LOW);
      delay(1000);                     // wait for a second//1초쉰다
}
